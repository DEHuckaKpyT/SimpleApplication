package nocom.DenCompany.SimpleApplication.runner;

import lombok.RequiredArgsConstructor;
import nocom.DenCompany.SimpleApplication.Parser;
import nocom.DenCompany.SimpleApplication.service.actionService.ActionService;
import nocom.DenCompany.SimpleApplication.service.inputService.ConsoleInputService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@ConditionalOnProperty(
        prefix = "command.line.runner",
        value = "enabled",
        havingValue = "true",
        matchIfMissing = true)
@RequiredArgsConstructor
@Component
public class StartApplication implements CommandLineRunner {

    private final ActionService actionService;

    @Override
    public void run(String... args) {
        List<Integer> digits = Parser.getDigitsByString(new ConsoleInputService().getLine());
        actionService.doAll(digits);
    }
}
