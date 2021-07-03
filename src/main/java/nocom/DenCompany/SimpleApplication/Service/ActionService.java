package nocom.DenCompany.SimpleApplication.Service;

import lombok.Data;
import nocom.DenCompany.SimpleApplication.Actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Component
public class ActionService {
    @Autowired
    List<Action> actions;
    List<Integer> digits;

    public void doAll() {
        for (Action action :
                actions) {
            action.doAction(digits);
        }
    }
}