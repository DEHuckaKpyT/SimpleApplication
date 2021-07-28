package nocom.DenCompany.SimpleApplication.Actions;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ActionSum implements Action {
    @Override
    public String doAction(List<Integer> digits) {
        String result = "Sum = " + digits.stream()
                .mapToInt(Integer::intValue)
                .sum();
        if (result.equals("Sum = 42"))
            throw new RuntimeException("Sum equals 42");
        return result;
    }
}
