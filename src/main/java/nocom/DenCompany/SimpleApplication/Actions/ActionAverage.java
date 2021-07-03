package nocom.DenCompany.SimpleApplication.Actions;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionAverage implements Action{
    @Override
    public String doAction(List<Integer> digits) {
        return ("Average = " + digits.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0));
    }
}
