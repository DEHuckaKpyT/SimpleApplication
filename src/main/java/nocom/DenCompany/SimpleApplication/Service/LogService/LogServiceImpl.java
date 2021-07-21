package nocom.DenCompany.SimpleApplication.Service.LogService;

import lombok.Builder;
import nocom.DenCompany.SimpleApplication.Entity.Log;
import nocom.DenCompany.SimpleApplication.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Builder
public class LogServiceImpl implements LogService {
    @Autowired
    LogRepository logRepository;

    @Override
    public Log log(Date date, String inputValue, String result) {

        Log logEntity = Log.builder()
                .date(date)
                .inputValue(inputValue)
                .result(result)
                .build();

        return logRepository.save(logEntity);
    }
}
