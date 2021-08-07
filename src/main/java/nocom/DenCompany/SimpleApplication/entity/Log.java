package nocom.DenCompany.SimpleApplication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
public class Log {

    @Id
    @GeneratedValue
    UUID id;

    @JsonFormat(pattern="yyyy-MM-dd")
    Date date;

    String inputValue;

    String result;
}
