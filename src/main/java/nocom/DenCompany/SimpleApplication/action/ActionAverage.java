package nocom.DenCompany.SimpleApplication.action;

import nocom.DenCompany.SimpleApplication.annotation.LogToTelegram;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionAverage implements Action{
    @Override
    @LogToTelegram
    public String doAction(List<Integer> digits) {
        String result = "Average = " + digits.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        if (result.equals("Average = 3.0"))
            throw new RuntimeException("Average was equals 3");
        return result;
    }
}
