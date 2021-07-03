package nocom.DenCompany.SimpleApplication.Runner;

import nocom.DenCompany.SimpleApplication.Service.ActionService;
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
    public void run(String... args) throws Exception {

        //TODO попрятать по классам
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        String string = in.nextLine();

        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < string.length(); i++){
            digits.add(string.charAt(i) - '0');
        }
        actionService.setDigits(digits);
        actionService.doAll();
    }
}
