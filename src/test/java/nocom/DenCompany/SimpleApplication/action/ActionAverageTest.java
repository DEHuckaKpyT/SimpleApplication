package nocom.DenCompany.SimpleApplication.action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ActionAverageTest {
    @Test
    void basicTest(){
        //arrange
        List<Integer> digits = Arrays.stream(new int[]{1, 2, 3})
                                     .boxed()
                                     .collect(Collectors.toList());
        //act
        String result = new ActionAverage().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Average = 2.0");
    }

    @Test
    void oneDigit(){
        //arrange
        List<Integer> digits = Arrays.stream(new int[]{5})
                                     .boxed()
                                     .collect(Collectors.toList());
        //act
        String result = new ActionAverage().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Average = 5.0");
    }

    @Test
    void emptyListOfDigits(){
        //arrange
        List<Integer> digits = Arrays.stream(new int[]{})
                                     .boxed()
                                     .collect(Collectors.toList());
        //act
        String result = new ActionAverage().doAction(digits);
        //assert
        Assertions.assertEquals(result, "Average = 0.0");
    }

    @Test
    void badAverage() {
        //arrange
        List<Integer> digits = Arrays.stream(new int[]{2, 3, 4})
                .boxed()
                .collect(Collectors.toList());
        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> new ActionAverage().doAction(digits));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Average was equals 3");
    }
}