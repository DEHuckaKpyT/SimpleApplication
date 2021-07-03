package nocom.DenCompany.SimpleApplication.Actions;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ActionSum implements Action {
    @Override
    public String doAction(List<Integer> digits) {
        return ("Sum = " + digits.stream()
                .mapToInt(Integer::intValue)
                .sum());
    }
}
