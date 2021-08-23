package nocom.DenCompany.SimpleApplication.service.logService;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.jupiter.tools.spring.test.postgres.annotation.meta.EnablePostgresIntegrationTest;
import nocom.DenCompany.SimpleApplication.entity.Log;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@EnablePostgresIntegrationTest
class LogServiceImplTest {

    @Autowired
    LogService logService;

    @Test
    @DataSet(cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet("/dataset/LogExpected.json")
    void logTest() {
        // Arrange
        Date date = new Date();
        String inputValue = "123";
        String result = "Average = 2.0";
        // Act
        logService.log(date, inputValue, result);
        // Asserts
    }


    @Test
    @DataSet(value = "/dataset/LogList.json", cleanBefore = true, cleanAfter = true)
    void getAllTest() throws ParseException {
        // Arrange
        List<Log> startLogs = Lists.list(
                new Log(UUID.fromString("a89b5ab1-17ac-462b-af33-9565631da3fa"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                                .parse("2021-08-10 14:11:45.842"),
                        "111",
                        "Average = 1.0"),
                new Log(UUID.fromString("7506690b-065c-4e8e-9b97-9fe170f3f158"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                                .parse("2021-08-10 14:11:46.192"),
                        "123",
                        "Max = 3"),
                new Log(UUID.fromString("074da972-97a1-43bb-845b-09837701c583"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                                .parse("2021-08-10 14:11:46.422"),
                        "123",
                        "Min = 1"),
                new Log(UUID.fromString("1013ef79-3dce-4afc-b343-0216d31093f9"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                                .parse("2021-08-10 14:11:46.632"),
                        "122",
                        "Sum = 5"));
        // Act
        List<Log> logs = logService.getAll();
        // Asserts
        assertThat(logs).isNotNull().isEqualTo(startLogs);
    }

    @Test
    @DataSet(value = "/dataset/LogList.json", cleanBefore = true, cleanAfter = true)
    void getFetchListInputValue123Test() throws ParseException {
        // Arrange
        List<Log> startLogs = Lists.list(
                new Log(UUID.fromString("7506690b-065c-4e8e-9b97-9fe170f3f158"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                                .parse("2021-08-10 14:11:46.192"),
                        "123",
                        "Max = 3"),
                new Log(UUID.fromString("074da972-97a1-43bb-845b-09837701c583"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                                .parse("2021-08-10 14:11:46.422"),
                        "123",
                        "Min = 1"));
        // Act
        List<Log> logs = logService.getFetchedList("inputValue:123");
        // Asserts
        assertThat(logs).isNotNull().isEqualTo(startLogs);
    }

    @Test
    @DataSet(value = "/dataset/LogList.json", cleanBefore = true, cleanAfter = true)
    void getFetchListResultMax3Test() throws ParseException {
        // Arrange
        List<Log> startLogs = Lists.list(
                new Log(UUID.fromString("7506690b-065c-4e8e-9b97-9fe170f3f158"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                                .parse("2021-08-10 14:11:46.192"),
                        "123",
                        "Max = 3"));
        // Act
        List<Log> logs = logService.getFetchedList("result:Max = 3");
        // Asserts
        assertThat(logs).isNotNull().isEqualTo(startLogs);
    }
}