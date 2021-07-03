package nocom.DenCompany.SimpleApplication.Service;

import lombok.Data;
import nocom.DenCompany.SimpleApplication.Actions.Action;
import nocom.DenCompany.SimpleApplication.Service.OutputService.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ActionService {
    @Autowired
    List<Action> actions;
    List<Integer> digits;
    @Autowired
    OutputService outputService;

    public void doAll() {
        for (Action action :
                actions) {
            outputService.writeLine(action.doAction(digits));
        }
    }
}