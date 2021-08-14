package nocom.DenCompany.SimpleApplication.action;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ActionMaxTest {

    ActionMax actionMax = new ActionMax();

    @Test
    void basicTest() {
        //arrange
        List<Integer> digits = Lists.list(5, 1, 3, 6, 1);
        //act
        String result = actionMax.doAction(digits);
        //assert
        Assertions.assertEquals(result, "Max = 6");
    }

    @Test
    void oneDigit() {
        //arrange
        List<Integer> digits = Lists.list(5);
        //act
        String result = actionMax.doAction(digits);
        //assert
        Assertions.assertEquals(result, "Max = 5");
    }

    @Test
    void emptyListOfDigits() {
        //arrange
        List<Integer> digits = Lists.list();
        //act
        String result = actionMax.doAction(digits);
        //assert
        Assertions.assertEquals(result, "Max = 0");
    }
}