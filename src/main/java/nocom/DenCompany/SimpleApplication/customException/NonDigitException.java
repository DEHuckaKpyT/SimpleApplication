package nocom.DenCompany.SimpleApplication.customException;

public class NonDigitException extends RuntimeException {

    public NonDigitException(String message) {
        super(message);
    }
}
