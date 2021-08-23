package nocom.DenCompany.SimpleApplication.service.outputService;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleOutputServiceTest {

    OutputService outputService = new ConsoleOutputService();

    @Test
    void writeLine() throws Exception {
        //arrange & act
        String text = tapSystemOut(() -> {
            outputService.writeLine("Max = 3");
        });

        //assert
        assertEquals("Max = 3", text.trim());
    }
}