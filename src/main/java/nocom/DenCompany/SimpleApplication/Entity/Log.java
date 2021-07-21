package nocom.DenCompany.SimpleApplication.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
public class Log {

    @Id
    @GeneratedValue
    UUID id;

    Date date;

    String inputValue;

    String result;
}
