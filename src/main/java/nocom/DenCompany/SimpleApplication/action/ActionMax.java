package nocom.DenCompany.SimpleApplication.action;

import nocom.DenCompany.SimpleApplication.annotation.LogToTelegram;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionMax implements Action{
    @Override
    @LogToTelegram
    public String doAction(List<Integer> digits) {
        return ("Max = " + digits.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0));
    }
}
