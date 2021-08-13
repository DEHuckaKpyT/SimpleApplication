package nocom.DenCompany.SimpleApplication.customException;

public class BadAverageValueException extends RuntimeException {

    public BadAverageValueException(String message) {
        super(message);
    }
}
