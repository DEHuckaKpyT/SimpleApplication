package nocom.DenCompany.SimpleApplication.Runner;

import nocom.DenCompany.SimpleApplication.Parser;
import nocom.DenCompany.SimpleApplication.Service.ActionService;
import nocom.DenCompany.SimpleApplication.Service.InputService.ConsoleInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
