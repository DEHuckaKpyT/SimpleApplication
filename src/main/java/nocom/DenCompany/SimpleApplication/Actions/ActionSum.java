package nocom.DenCompany.SimpleApplication.Actions;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ActionSum implements Action {
    @Override
    public void doAction(List<Integer> digits) {
        System.out.println("Sum = " + digits.stream()
                .mapToInt(Integer::intValue)
                .sum());
    }
}
