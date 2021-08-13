package nocom.DenCompany.SimpleApplication.action;

import nocom.DenCompany.SimpleApplication.annotation.LogToDB;
import nocom.DenCompany.SimpleApplication.annotation.LogToTelegram;
import nocom.DenCompany.SimpleApplication.customException.customExceptionHandler.SumValueExceptionHandler;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ActionSum implements Action {
    @Override
    @LogToTelegram
    @LogToDB
    public String doAction(List<Integer> digits) {

        String result = "Sum = " + digits.stream()
                .mapToInt(Integer::intValue)
                .sum();

        SumValueExceptionHandler.checkSumResult(result);

        return result;
    }
}
