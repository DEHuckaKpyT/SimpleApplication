package nocom.DenCompany.SimpleApplication.customException.customExceptionHandler;

import nocom.DenCompany.SimpleApplication.customException.BadSumValueException;

public class SumValueExceptionHandler {
    public static void checkSumResult(String result){
        if (result.equals("Sum = 42"))
            throw new BadSumValueException("Error: Sum equals 42");
    }
}
