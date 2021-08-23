package nocom.DenCompany.SimpleApplication;

import nocom.DenCompany.SimpleApplication.customException.customExceptionChecker.ParserExceptionChecker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Parser {

    public static List<Integer> getDigitsByString(String string) {

        ParserExceptionChecker.checkStringWithDigits(string);

        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            digits.add(string.charAt(i) - '0');
        }

        return digits;
    }

    public static String getStringByDigits(List<Integer> digits) {

        StringBuilder inputString = new StringBuilder();
        for (Integer digit :
                digits) {
            inputString.append(digit.toString());
        }

        return inputString.toString();
    }
}
