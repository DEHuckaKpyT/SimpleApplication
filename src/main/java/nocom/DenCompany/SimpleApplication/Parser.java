package nocom.DenCompany.SimpleApplication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Parser {

    public List<Integer> getDigitsByString(String string) {

        if (string.length() > 100)
            throw new RuntimeException("String has > 100 symbols");
        if (string.contains("666"))
            throw new RuntimeException("String contains substring \"666\"");
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (currentChar < '0' || currentChar > '9')
                throw new RuntimeException("String has symbol which not equals digit");
            digits.add(currentChar - '0');
        }

        return digits;
    }

    public static String getStringByDigits(List<Integer> digits) {

        String inputString = "";
        for (Integer digit :
                digits) {
            inputString += digit.toString();
        }

        return inputString;
    }
}
