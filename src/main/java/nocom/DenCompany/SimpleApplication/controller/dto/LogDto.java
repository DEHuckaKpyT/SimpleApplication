package nocom.DenCompany.SimpleApplication.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogDto {

    String inputValue;
    String result;

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getInputValue() {
        return inputValue;
    }

    public String getResult() {
        return result;
    }
}
