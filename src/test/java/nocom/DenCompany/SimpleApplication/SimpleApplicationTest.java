package nocom.DenCompany.SimpleApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"telegram.bot.token="})
class SimpleApplicationTest {

    @Test
    void contextLoads() {
    }
}