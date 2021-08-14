package nocom.DenCompany.SimpleApplication.action;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ActionMinTest {

    ActionMin actionMin = new ActionMin();
    @Test
    void basicTest(){
        //arrange
        List<Integer> digits = Lists.list(5, 1, 3, 6, 1);
        //act
        String result = actionMin.doAction(digits);
        //assert
        Assertions.assertEquals(result, "Min = 1");
    }

    @Test
    void oneDigit(){
        //arrange
        List<Integer> digits = Lists.list(5);
        //act
        String result = actionMin.doAction(digits);
        //assert
        Assertions.assertEquals(result, "Min = 5");
    }

    @Test
    void emptyListOfDigits(){
        //arrange
        List<Integer> digits = Lists.list();
        //act
        String result = actionMin.doAction(digits);
        //assert
        Assertions.assertEquals(result, "Min = 0");
    }
}