package nocom.DenCompany.SimpleApplication.runner;

import nocom.DenCompany.SimpleApplication.Parser;
import nocom.DenCompany.SimpleApplication.service.ActionService;
import nocom.DenCompany.SimpleApplication.service.inputService.ConsoleInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    @Autowired
    ActionService actionService;

    @Override
    public void run(String... args) {
        List<Integer> digits = new Parser().getDigitsByString(new ConsoleInputService().getLine());

        actionService.setDigits(digits);
        actionService.doAll();
    }
}
