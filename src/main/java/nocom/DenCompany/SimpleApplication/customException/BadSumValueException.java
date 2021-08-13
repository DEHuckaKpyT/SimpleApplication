package nocom.DenCompany.SimpleApplication.customException;

public class BadSumValueException extends RuntimeException {

    public BadSumValueException(String message) {
        super(message);
    }
}
