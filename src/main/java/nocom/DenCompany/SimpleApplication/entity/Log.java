package nocom.DenCompany.SimpleApplication.entity;

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

    @Column
    Date date;

    @Column
    String inputValue;

    @Column
    String result;

    public String getInputValue() {
        return inputValue;
    }

    public String getResult() {
        return result;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public void setResult(String result) {
        this.result = result;
    }

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
