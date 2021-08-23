package nocom.DenCompany.SimpleApplication.customException.customExceptionChecker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumValueExceptionCheckerTest {

    @Test
    void checkSumResultException() {
        //arrange
        String result = "Sum = 42";
        //act
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> SumValueExceptionChecker.checkSumResult(result));
        //assert
        Assertions.assertEquals(runtimeException.getMessage(),"Error: Sum equals 42");
    }

    @Test
    void checkSumResultClear() {
        //arrange
        String result = "Sum = 10";
        //act
        SumValueExceptionChecker.checkSumResult(result);
        //assert
        //nothing
    }
}