package nocom.DenCompany.SimpleApplication.action;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ActionSumTest {

    @Test
    void BasicTest(){
        //arrange
        List<Integer> digits = Lists.list(5, 1, 3, 6, 1);
        //act
        String result = new ActionSum().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Sum = 16");
    }

    @Test
    void OneDigit(){
        //arrange
        List<Integer> digits = Lists.list(5);
        //act
        String result = new ActionSum().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Sum = 5");
    }

    @Test
    void EmptyListOfDigits(){
        //arrange
        List<Integer> digits = Lists.list();
        //act
        String result = new ActionSum().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Sum = 0");
    }

    @Test
    void badSum() {
        //arrange
        List<Integer> digits = Lists.list(9, 9, 9, 9, 6);
        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> new ActionSum().doAction(digits));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Sum equals 42");
    }
}