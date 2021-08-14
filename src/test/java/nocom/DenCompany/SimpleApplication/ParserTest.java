package nocom.DenCompany.SimpleApplication;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void basicTest() {
        //arrange
        String string = "136";

        //act
        List<Integer> result = Parser.getDigitsByString(string);

        //assert
        assertEquals(result, Lists.list(1, 3, 6));
    }

    @Test
    void checkLength() {
        //arrange
        String string = "";
        for (int i = 0; i < 101; i++) {
            string += '0';
        }

        //act
        String finalString = string;
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> Parser.getDigitsByString(finalString));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Error: String has > 100 symbols");
    }

    @Test
    void checkSymbolsForDigits() {
        //arrange
        String string = "123haha";

        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> Parser.getDigitsByString(string));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Error: String has symbol which not equals digit");
    }

    @Test
    void checkSymbolsForSubstring666() {
        //arrange
        String string = "345666413";

        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> Parser.getDigitsByString(string));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Error: String contains substring \"666\"");
    }
}