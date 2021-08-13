package nocom.DenCompany.SimpleApplication.service.inputService;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleInputService implements InputService {
    @Override
    public String getLine() {
        String input;

        System.out.print("Input a string: ");
        try(Scanner in = new Scanner(System.in)) {
            input = in.nextLine();
        }

        return input;
    }
}
