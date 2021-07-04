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
    void basicTest(){
        //arrange
        String string = "136";

        //act
        List<Integer> result = new Parser().getDigitsByString(string);

        //assert
        assertEquals(result, Arrays.stream(new int[]{1, 3, 6})
                                   .boxed()
                                   .collect(Collectors.toList()));
    }
}