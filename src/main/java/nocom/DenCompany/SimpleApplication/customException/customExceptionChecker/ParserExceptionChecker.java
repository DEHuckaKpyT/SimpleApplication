package nocom.DenCompany.SimpleApplication.customException.customExceptionChecker;

import nocom.DenCompany.SimpleApplication.customException.NonDigitException;
import nocom.DenCompany.SimpleApplication.customException.StringWith666Exception;
import nocom.DenCompany.SimpleApplication.customException.TooLongStringException;

public class ParserExceptionChecker {
    public static void checkStringWithDigits(String string) {

        if (string.length() > 100)
            throw new TooLongStringException("Error: String has > 100 symbols");
        if (string.contains("666"))
            throw new StringWith666Exception("Error: String contains substring \"666\"");
        if (!string.matches("\\d*"))
            throw new NonDigitException("Error: String has symbol which not equals digit");
    }
}
