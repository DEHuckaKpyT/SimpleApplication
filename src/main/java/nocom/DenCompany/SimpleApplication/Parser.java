package nocom.DenCompany.SimpleApplication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Parser {

    public List<Integer> getDigitsByString(String string){

        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < string.length(); i++){
            digits.add(string.charAt(i) - '0');
        }

        return digits;
    }
}
