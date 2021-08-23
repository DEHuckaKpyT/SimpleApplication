package nocom.DenCompany.SimpleApplication.customException.customExceptionChecker;

import nocom.DenCompany.SimpleApplication.customException.BadSumValueException;

public class SumValueExceptionChecker {
    public static void checkSumResult(String result){
        if (result.equals("Sum = 42"))
            throw new BadSumValueException("Error: Sum equals 42");
    }
}
