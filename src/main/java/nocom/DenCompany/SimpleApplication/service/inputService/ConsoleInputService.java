package nocom.DenCompany.SimpleApplication.service.inputService;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleInputService implements InputService {
    @Override
    public String getLine() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        return in.nextLine();
    }
}