package nocom.DenCompany.SimpleApplication.scheduler;

import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.service.logService.LogService;
import nocom.DenCompany.SimpleApplication.service.notificationService.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class TelegramScheduler {

    LogService logService;
    List<NotificationService> notificationServices;

    @Autowired
    public TelegramScheduler(LogService logService, List<NotificationService> notificationServices) {
        this.logService = logService;
        this.notificationServices = notificationServices;
    }

    @Scheduled(cron = "${scheduler.time}")
    public void eveningSchedulerSummaryReport() throws IOException {
        String summaryReport = summaryReport();
        for (NotificationService notificationService:
                notificationServices) {
            notificationService.send(summaryReport);
        }
    }

    private String summaryReport(){
        StringBuilder report = new StringBuilder("Daily Report:%0A");
        for (Log log:
        logService.getAll()) {
            report.append(log.getResult()).append("%0A");
        }

        return report.toString();
    }
}
