package nocom.DenCompany.SimpleApplication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Log {

    @Id
    @GeneratedValue
    UUID id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    Date date;

    String inputValue;

    String result;

    //TODO не нашёл другого более правильного решения сравнить две даты в разных форматах
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Log)) {
            return false;
        }

        Log log = (Log) o;

        if (this.id.equals(log.getId()) &&
                this.date.getTime() == log.date.getTime() &&
                this.inputValue.equals(log.getInputValue()) &&
                this.result.equals(log.getResult()))
            return true;
        else
            return false;

    }
}
