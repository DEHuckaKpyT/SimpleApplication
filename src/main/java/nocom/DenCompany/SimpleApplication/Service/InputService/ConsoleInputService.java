package nocom.DenCompany.SimpleApplication.Service.InputService;

import java.util.Scanner;

public class ConsoleInputService implements InputService {
    @Override
    public String getLine() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        return in.nextLine();
    }
}
