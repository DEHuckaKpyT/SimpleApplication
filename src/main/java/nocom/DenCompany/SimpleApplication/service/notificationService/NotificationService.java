package nocom.DenCompany.SimpleApplication.service.notificationService;


import java.io.IOException;
import java.util.concurrent.Future;

public interface NotificationService {
    Future<String> send(String notification) throws IOException;
}
