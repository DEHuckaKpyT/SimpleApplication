package nocom.DenCompany.SimpleApplication.Actions;


import nocom.DenCompany.SimpleApplication.Annotation.LogToTelegram;

import java.util.List;

public interface Action {
    String doAction(List<Integer> digits);
}
