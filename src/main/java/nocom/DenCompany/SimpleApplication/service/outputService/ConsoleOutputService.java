package nocom.DenCompany.SimpleApplication.service.outputService;

import org.springframework.stereotype.Service;

@Service
public class ConsoleOutputService implements OutputService {
    @Override
    public void writeLine(String string) {
        System.out.println(string);
    }
}
