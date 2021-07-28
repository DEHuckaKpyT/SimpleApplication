package nocom.DenCompany.SimpleApplication.Entity;

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

    @Column
    Date date;

    @Column
    String inputValue;

    @Column
    String result;
}
