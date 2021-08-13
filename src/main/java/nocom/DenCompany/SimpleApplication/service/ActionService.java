package nocom.DenCompany.SimpleApplication.service;

import lombok.Data;
import nocom.DenCompany.SimpleApplication.action.Action;
import nocom.DenCompany.SimpleApplication.service.outputService.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ActionService {
    List<Action> actions;
    List<Integer> digits;
    OutputService outputService;

    @Autowired
    public ActionService(List<Action> actions, OutputService outputService) {
        this.actions = actions;
        this.outputService = outputService;
    }

    public void doAll() {
        for (Action action :
                actions) {
            String answer = action.doAction(digits);
            outputService.writeLine(answer);
        }
    }
}