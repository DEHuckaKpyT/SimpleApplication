package nocom.DenCompany.SimpleApplication.action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ActionMaxTest {

    @Test
    void BasicTest(){
        //arrange
        List<Integer> digits = Arrays.stream(new int[]{5, 1, 3, 6, 1})
                                     .boxed()
                                     .collect(Collectors.toList());
        //act
        String result = new ActionMax().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Max = 6");
    }

    @Test
    void OneDigit(){
        //arrange
        List<Integer> digits = Arrays.stream(new int[]{5})
                                     .boxed()
                                     .collect(Collectors.toList());
        //act
        String result = new ActionMax().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Max = 5");
    }

    @Test
    void EmptyListOfDigits(){
        //arrange
        List<Integer> digits = Arrays.stream(new int[]{})
                                     .boxed()
                                     .collect(Collectors.toList());
        //act
        String result = new ActionMax().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Max = 0");
    }
}