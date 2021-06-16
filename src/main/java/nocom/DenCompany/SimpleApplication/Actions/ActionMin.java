package nocom.DenCompany.SimpleApplication.Actions;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionMin implements Action{
    @Override
    public void doAction(List<Integer> digits) {
        System.out.println("Min = " + digits.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0));
    }
}
