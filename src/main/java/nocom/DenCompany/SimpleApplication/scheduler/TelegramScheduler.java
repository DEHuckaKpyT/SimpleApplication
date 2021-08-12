package nocom.DenCompany.SimpleApplication.scheduler;

import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.service.logService.LogService;
import nocom.DenCompany.SimpleApplication.service.notificationService.NotificationService;
import nocom.DenCompany.SimpleApplication.service.notificationService.TelegramNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class TelegramScheduler {

    @Autowired
    LogService logService;
    @Autowired
    List<NotificationService> notificationServices;

    @Scheduled(cron = "0 0 19 * * MON-FRI")
    public void eveningSchedulerSummaryReport() throws IOException {
        String summaryReport = SummaryReport();
        for (NotificationService notificationService:
                notificationServices) {
            notificationService.send(summaryReport);
        }
    }

    private String SummaryReport(){
        StringBuilder report = new StringBuilder("Daily Report:%0A");
        for (Log log:
        logService.getAll()) {
            report.append(log.getResult()).append("%0A");
        }

        return report.toString();
    }
}
