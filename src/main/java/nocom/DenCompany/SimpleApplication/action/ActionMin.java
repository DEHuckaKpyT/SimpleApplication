package nocom.DenCompany.SimpleApplication.action;

import nocom.DenCompany.SimpleApplication.annotation.LogToTelegram;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionMin implements Action{
    @Override
    @LogToTelegram
    public String doAction(List<Integer> digits) {
        return ("Min = " + digits.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0));
    }
}
