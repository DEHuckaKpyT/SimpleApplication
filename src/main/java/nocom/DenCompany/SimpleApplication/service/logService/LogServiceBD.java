package nocom.DenCompany.SimpleApplication.service.logService;

import lombok.Builder;
import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Builder
public class LogServiceBD implements LogService {

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

    @Override
    public List<Log> getAll() {
        return logRepository.findAll();
    }
}
