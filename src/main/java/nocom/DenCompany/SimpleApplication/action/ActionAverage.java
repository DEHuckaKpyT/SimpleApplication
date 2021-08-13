package nocom.DenCompany.SimpleApplication.action;

import nocom.DenCompany.SimpleApplication.annotation.LogToDB;
import nocom.DenCompany.SimpleApplication.annotation.LogToTelegram;
import nocom.DenCompany.SimpleApplication.customException.customExceptionHandler.AverageValueExceptionHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionAverage implements Action{

    @Override
    @LogToTelegram
    @LogToDB
    public String doAction(List<Integer> digits) {

        String result = "Average = " + digits.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        AverageValueExceptionHandler.checkAverageResult(result);

        return result;
    }
}
