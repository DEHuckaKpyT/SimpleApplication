package nocom.DenCompany.SimpleApplication.service.actionService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import nocom.DenCompany.SimpleApplication.action.Action;
import nocom.DenCompany.SimpleApplication.service.outputService.OutputService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class ActionServiceImpl implements ActionService {

    private final List<Action> actions;
    private final OutputService outputService;

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