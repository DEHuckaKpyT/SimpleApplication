package nocom.DenCompany.SimpleApplication.service.logService;

import com.github.database.rider.core.api.dataset.DataSet;
import com.jupiter.tools.spring.test.postgres.annotation.meta.EnablePostgresIntegrationTest;
import nocom.DenCompany.SimpleApplication.entity.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@EnablePostgresIntegrationTest
class LogServiceBDTest {

    @Autowired
    LogService logService;

    @Test
    @DataSet(value = "/dataset/LogList.json", cleanBefore = true, cleanAfter = true)
    void getAllTest() {
        // Arrange
        List<Log> startLogs = Arrays.stream(new Log[]{
                new Log(UUID.fromString("a89b5ab1-17ac-462b-af33-9565631da3fa"),
                        new Date("2021-08-10T14:11:45.842"),
                        "11",
                        "Average = 1.0"),
                new Log(UUID.fromString("7506690b-065c-4e8e-9b97-9fe170f3f158"),
                        new Date("2021-08-10T14:11:46.192"),
                        "11",
                        "Max = 1"),
                new Log(UUID.fromString("074da972-97a1-43bb-845b-09837701c583"),
                        new Date("2021-08-10T14:11:46.422"),
                        "11",
                        "Min = 1"),
                new Log(UUID.fromString("1013ef79-3dce-4afc-b343-0216d31093f9"),
                        new Date("2021-08-10T14:11:46.632"),
                        "11",
                        "Sum = 2")
        }).collect(Collectors.toList());
        // Act
        List<Log> logs = logService.getAll();
        // Asserts
        assertThat(logs).isNotNull().isEqualTo(startLogs);
    }
}