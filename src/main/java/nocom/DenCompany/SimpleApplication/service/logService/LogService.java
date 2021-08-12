package nocom.DenCompany.SimpleApplication.service.logService;

import nocom.DenCompany.SimpleApplication.entity.Log;

import java.util.Date;
import java.util.List;

public interface LogService {
    Log log(Date date, String inputValue, String result);
    List<Log> getAll();
    List<Log> getFetchedList(String params);
}
