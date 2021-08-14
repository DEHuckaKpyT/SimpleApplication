package nocom.DenCompany.SimpleApplication.controller;

import nocom.DenCompany.SimpleApplication.customException.*;
import nocom.DenCompany.SimpleApplication.controller.dto.ErrorDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(PRECONDITION_FAILED)
    @ExceptionHandler(value = {BadAverageValueException.class,
            BadSumValueException.class,
            NonDigitException.class,
            StringWith666Exception.class,
            TooLongStringException.class})
    public ErrorDto preconditionFailed(RuntimeException exception) {
        return new ErrorDto(exception.getMessage());
    }
}
