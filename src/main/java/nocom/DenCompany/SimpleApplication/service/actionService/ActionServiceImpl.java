package nocom.DenCompany.SimpleApplication.service.actionService;

import lombok.Data;
import nocom.DenCompany.SimpleApplication.action.Action;
import nocom.DenCompany.SimpleApplication.service.outputService.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ActionServiceImpl implements ActionService{
    List<Action> actions;
    OutputService outputService;

    @Autowired
    public ActionServiceImpl(List<Action> actions, OutputService outputService) {
        this.actions = actions;
        this.outputService = outputService;
    }

    public List<String> doAll(List<Integer> digits) {
        List<String> answers = new ArrayList<>();
        for (Action action :
                actions) {
            String answer = action.doAction(digits);
            answers.add(answer);
            outputService.writeLine(answer);
        }
        return answers;
    }
}