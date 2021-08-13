package nocom.DenCompany.SimpleApplication.customException;

public class TooLongStringException extends RuntimeException {

    public TooLongStringException(String message) {
        super(message);
    }
}
