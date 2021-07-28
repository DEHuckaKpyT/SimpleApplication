package nocom.DenCompany.SimpleApplication;

import nocom.DenCompany.SimpleApplication.Actions.ActionAverage;
import org.assertj.core.api.Assert;
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
        List<Integer> result = new Parser().getDigitsByString(string);

        //assert
        assertEquals(result, Arrays.stream(new int[]{1, 3, 6})
                .boxed()
                .collect(Collectors.toList()));
    }

    @Test
    void checkLength() {
        //arrange
        String string = "";
        for (int i = 0; i < 101; i++) {
            string += '0';
        }
        Parser parser = new Parser();

        //act
        String finalString = string;
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> parser.getDigitsByString(finalString));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"String has > 100 symbols");
    }

    @Test
    void checkSymbolsForDigits() {
        //arrange
        String string = "123haha";
        Parser parser = new Parser();

        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> parser.getDigitsByString(string));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"String has symbol which not equals digit");
    }

    @Test
    void checkSymbolsForSubstring666() {
        //arrange
        String string = "345666413";
        Parser parser = new Parser();

        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> parser.getDigitsByString(string));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"String contains substring \"666\"");
    }
}