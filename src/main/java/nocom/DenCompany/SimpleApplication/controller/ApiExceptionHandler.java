package nocom.DenCompany.SimpleApplication.controller;

import nocom.DenCompany.SimpleApplication.customException.*;
import nocom.DenCompany.SimpleApplication.controller.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {BadAverageValueException.class})
    public ResponseEntity<Object> badAverageValue(RuntimeException exception) {
        return new ResponseEntity<Object>(
                new ErrorDto(exception.getMessage()), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(value = {BadSumValueException.class})
    public ResponseEntity<Object> badSumValue(RuntimeException exception) {
        return new ResponseEntity<Object>(
                new ErrorDto(exception.getMessage()), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(value = {NonDigitException.class})
    public ResponseEntity<Object> containsBadSymbol(RuntimeException exception) {
        return new ResponseEntity<Object>(
                new ErrorDto(exception.getMessage()), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(value = {StringWith666Exception.class})
    public ResponseEntity<Object> contains666(RuntimeException exception) {
        return new ResponseEntity<Object>(
                new ErrorDto(exception.getMessage()), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(value = {TooLongStringException.class})
    public ResponseEntity<Object> tooLongString(RuntimeException exception) {
        return new ResponseEntity<Object>(
                new ErrorDto(exception.getMessage()), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED);
    }
}
