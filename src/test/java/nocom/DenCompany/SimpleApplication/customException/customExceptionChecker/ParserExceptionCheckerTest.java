package nocom.DenCompany.SimpleApplication.customException.customExceptionChecker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserExceptionCheckerTest {

    @Test
    void checkStringWithDigitsExceptionLongString() {
        //arrange
        StringBuilder string = new StringBuilder();
        for(int i = 0; i< 101; i++)
            string.append("1");
        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> ParserExceptionChecker.checkStringWithDigits(string.toString()));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Error: String has > 100 symbols");
    }

    @Test
    void checkStringWithDigitsExceptionContains666() {
        //arrange
        String string = "126663";
        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> ParserExceptionChecker.checkStringWithDigits(string));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Error: String contains substring \"666\"");
    }

    @Test
    void checkStringWithDigitsExceptionNonDigit() {
        //arrange
        String string = "12a3";
        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> ParserExceptionChecker.checkStringWithDigits(string));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Error: String has symbol which not equals digit");
    }

    @Test
    void checkStringWithDigitsClear() {
        //arrange
        String string = "123";
        //act
        ParserExceptionChecker.checkStringWithDigits(string);
        //assert
        //nothing
    }
}