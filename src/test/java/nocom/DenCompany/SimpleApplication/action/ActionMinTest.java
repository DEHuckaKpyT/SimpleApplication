package nocom.DenCompany.SimpleApplication.action;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ActionMinTest {

    @Test
    void BasicTest(){
        //arrange
        List<Integer> digits = Lists.list(5, 1, 3, 6, 1);
        //act
        String result = new ActionMin().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Min = 1");
    }

    @Test
    void OneDigit(){
        //arrange
        List<Integer> digits = Lists.list(5);
        //act
        String result = new ActionMin().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Min = 5");
    }

    @Test
    void EmptyListOfDigits(){
        //arrange
        List<Integer> digits = Lists.list();
        //act
        String result = new ActionMin().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Min = 0");
    }
}