package nocom.DenCompany.SimpleApplication.service.notificationService;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Future;

@Service
public class TelegramNotificationService implements NotificationService {
    @Async
    @Override
    public Future<String> send(String notification) throws IOException {
        String url = "https://api.telegram.org/bot" + System.getenv("TelegramBotToken")
                + "/sendMessage?chat_id=1165327523&text="
                + notification;

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return new AsyncResult<String>(response.toString());
    }
}
