package nocom.DenCompany.SimpleApplication.customException.customExceptionChecker;

import nocom.DenCompany.SimpleApplication.customException.BadAverageValueException;

public class AverageValueExceptionChecker {

    public static void checkAverageResult(String result){
        if (result.equals("Average = 3.0"))
            throw new BadAverageValueException("Error: Average was equals 3");
    }
}
