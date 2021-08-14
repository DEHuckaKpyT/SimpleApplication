package nocom.DenCompany.SimpleApplication.service.notificationService;

import com.jupiter.tools.spring.test.core.annotation.EnableIntegrationTest;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(properties = {"telegram.bot.token="})
class TelegramNotificationServiceTest {

    @MockBean
    HttpURLConnection mockHttpConnection;
    @MockBean
    URL mockUrl;
    @Autowired
    NotificationService notificationService;

    @Test
    void sendTest() throws IOException, ExecutionException, InterruptedException {
//        //arrange
//        String message = "hello";
////        when(mockUrl.openConnection()).thenReturn(new URL("http://localhost:8080").openConnection());
////        when(mockHttpConnection.getInputStream()).thenReturn(new StringBufferInputStream(message));
//        //act
//        String returnedValue = notificationService.send("test").get();
//        //assert
//        verify(mockHttpConnection).getInputStream();
////        assertTrue(returnedValue.matches("^\\{\"ok\":true\\w*"));
    }
}