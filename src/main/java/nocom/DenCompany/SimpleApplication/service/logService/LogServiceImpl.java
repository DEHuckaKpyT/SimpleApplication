package nocom.DenCompany.SimpleApplication.service.logService;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.entity.custom.LogPredicatesBuilder;
import nocom.DenCompany.SimpleApplication.repository.LogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Builder
@RequiredArgsConstructor
@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Transactional
    @Override
    public Log log(Date date, String inputValue, String result) {

        Log logEntity = Log.builder()
                .date(date)
                .inputValue(inputValue)
                .result(result)
                .build();

        return logRepository.save(logEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Log> getAll() {
        return logRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Log> getFetchedList(String params) {
        LogPredicatesBuilder builder = new LogPredicatesBuilder();

        if (params != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)([\\w- .:=]+?),");
            Matcher matcher = pattern.matcher(params + ",");
            while (matcher.find()) {
                builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            }
        }
        BooleanExpression exp = builder.build();

        return (List<Log>) logRepository.findAll(exp);
    }
}
