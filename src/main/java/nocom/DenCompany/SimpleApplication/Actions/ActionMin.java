package nocom.DenCompany.SimpleApplication.Actions;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionMin implements Action{
    @Override
    public String doAction(List<Integer> digits) {
        return ("Min = " + digits.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0));
    }
}
