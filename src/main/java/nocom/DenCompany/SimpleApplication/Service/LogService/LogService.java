package nocom.DenCompany.SimpleApplication.Service.LogService;

import nocom.DenCompany.SimpleApplication.Entity.Log;

import java.util.Date;

public interface LogService {
    Log log(Date date, String inputValue, String result);
}
