package nocom.DenCompany.SimpleApplication.annotation.aspect;

import lombok.RequiredArgsConstructor;
import nocom.DenCompany.SimpleApplication.Parser;
import nocom.DenCompany.SimpleApplication.service.logService.LogService;
import nocom.DenCompany.SimpleApplication.service.notificationService.NotificationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;


@Aspect
@Component
@RequiredArgsConstructor
public class Logging {

    private final LogService logService;
    private final List<NotificationService> notificationServices;

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
