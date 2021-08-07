package nocom.DenCompany.SimpleApplication.aspect;

import nocom.DenCompany.SimpleApplication.Parser;
import nocom.DenCompany.SimpleApplication.service.logService.LogService;
import nocom.DenCompany.SimpleApplication.service.logService.LogServiceBD;
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

    @Autowired
    LogServiceBD logServiceBD;
    @Pointcut("@annotation(nocom.DenCompany.SimpleApplication.annotation.LogToTelegram)")
    public void logToTelegram() {
    }

    //TODO лениво сделал отправку уведомления в телеграм (посчитал, что это не так важно)
    @AfterReturning(pointcut = "logToTelegram()", returning = "result")
    public void logToTelegramAfterReturning(Object result) throws IOException {
//        String test = System.getenv("Token");
//        String url = "https://api.telegram.org/bot1916660240:"+System.getenv("Token")+"/sendMessage?chat_id=1165327523&text="
//                + result.toString();
//
//        URL obj = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
//
//        connection.setRequestMethod("GET");
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();

//        System.out.println(response.toString());
    }

    @Pointcut("@annotation(nocom.DenCompany.SimpleApplication.annotation.LogToDB)")
    public void logToDB() {
    }
        //TODO не получилось ограничить использование аннотации (чтобы был только List<Integer> параметр)
    @AfterReturning(pointcut = "logToDB()", returning = "result")
    public void logToDBAfterReturning(JoinPoint joinPoint, String result) {
        List<Integer> digits = (List<Integer>) joinPoint.getArgs()[0];
        String inputString = Parser.getStringByDigits(digits);

        logServiceBD.log(new Date(), inputString, result);
    }
}
