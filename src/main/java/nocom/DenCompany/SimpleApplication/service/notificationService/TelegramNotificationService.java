package nocom.DenCompany.SimpleApplication.service.notificationService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Future;

@ConditionalOnProperty(
        prefix = "telegram.notification.service",
        value = "enabled",
        havingValue = "true",
        matchIfMissing = true)
@Service
public class TelegramNotificationService implements NotificationService {

    @Value("${telegram.bot.token}")
    String telegramBotToken;

    @Async
    @Override
    public Future<String> send(String notification) throws IOException {
        String url = "https://api.telegram.org/bot" + telegramBotToken
                + "/sendMessage?chat_id=1165327523&text="
                + notification;

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        return new AsyncResult<String>(response.toString());
    }
}
