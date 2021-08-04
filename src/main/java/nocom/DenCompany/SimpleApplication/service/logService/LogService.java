package nocom.DenCompany.SimpleApplication.service.logService;

import nocom.DenCompany.SimpleApplication.entity.Log;

import java.util.Date;

public interface LogService {
    Log log(Date date, String inputValue, String result);
}
