package nocom.DenCompany.SimpleApplication.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Aspect
@Component
public class Logging {

    @Pointcut("@annotation(nocom.DenCompany.SimpleApplication.Annotation.LogToTelegram)")
    public void logToTelegram() { }

    @AfterReturning(pointcut="logToTelegram()", returning="result")
    public void logToTelegramAfterReturning(Object result) throws IOException {
        String url = "https://api.telegram.org/bot1916660240:AAFQOWTdJrsLaz8rdaXbBB83s_PGOp3wy8I/sendMessage?chat_id=1165327523&text="
                + result.toString();

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

//        System.out.println(response.toString());
    }
}
