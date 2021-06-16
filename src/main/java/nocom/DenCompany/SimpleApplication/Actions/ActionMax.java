package nocom.DenCompany.SimpleApplication.Actions;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionMax implements Action{
    @Override
    public void doAction(List<Integer> digits) {
        System.out.println("Max = " + digits.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0));
    }
}
