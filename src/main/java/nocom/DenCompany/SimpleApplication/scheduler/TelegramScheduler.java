package nocom.DenCompany.SimpleApplication.scheduler;

import lombok.RequiredArgsConstructor;
import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.service.logService.LogService;
import nocom.DenCompany.SimpleApplication.service.notificationService.NotificationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@ConditionalOnProperty(
        prefix = "telegram.scheduler",
        value = "enabled",
        havingValue = "true",
        matchIfMissing = true)
@RequiredArgsConstructor
@Component
public class TelegramScheduler {

    private final LogService logService;
    private final List<NotificationService> notificationServices;

    @Scheduled(cron = "${telegram.scheduler.time}")
    public void eveningSchedulerSummaryReport() throws IOException {
        String summaryReport = summaryReport();
        for (NotificationService notificationService :
                notificationServices) {
            notificationService.send(summaryReport);
        }
    }

    private String summaryReport() {
        StringBuilder report = new StringBuilder("Daily Report:%0A");
        for (Log log :
                logService.getAll()) {
            report.append(log.getResult()).append("%0A");
        }

        return report.toString();
    }
}
