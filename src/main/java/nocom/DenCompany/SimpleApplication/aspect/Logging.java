package nocom.DenCompany.SimpleApplication.aspect;

import nocom.DenCompany.SimpleApplication.Parser;
import nocom.DenCompany.SimpleApplication.service.logService.LogService;
import nocom.DenCompany.SimpleApplication.service.notificationService.NotificationService;
import nocom.DenCompany.SimpleApplication.service.notificationService.TelegramNotificationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;


@Aspect
@Component
public class Logging {

    LogService logService;
    List<NotificationService> notificationServices;

    @Autowired
    public Logging(LogService logService, List<NotificationService> notificationServices) {
        this.logService = logService;
        this.notificationServices = notificationServices;
    }

    @Pointcut("@annotation(nocom.DenCompany.SimpleApplication.annotation.LogToTelegram)")
    public void logToTelegram() {
    }

    @AfterReturning(pointcut = "logToTelegram()", returning = "result")
    public void logToTelegramAfterReturning(String result) throws IOException {
        for (NotificationService notificationService :
                notificationServices) {
            notificationService.send(result);
        }
    }

    @Pointcut("@annotation(nocom.DenCompany.SimpleApplication.annotation.LogToDB)")
    public void logToDB() {
    }

    @AfterReturning(pointcut = "logToDB()", returning = "result")
    public void logToDBAfterReturning(JoinPoint joinPoint, String result) {
        List<Integer> digits = (List<Integer>) joinPoint.getArgs()[0];
        String inputString = Parser.getStringByDigits(digits);

        logService.log(new Date(), inputString, result);
    }
}
