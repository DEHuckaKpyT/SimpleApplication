package nocom.DenCompany.SimpleApplication.customException.customExceptionChecker;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AverageValueExceptionCheckerTest {

    @Test
    void checkAverageResultException() {
        //arrange
        String result = "Average = 3.0";
        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> AverageValueExceptionChecker.checkAverageResult(result));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Error: Average was equals 3");
    }

    @Test
    void checkAverageResultClear() {
        //arrange
        String result = "Average = 2.0";
        //act
        AverageValueExceptionChecker.checkAverageResult(result);
        //assert
        //nothing
    }
}