package nocom.DenCompany.SimpleApplication.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.entity.QLog;
import nocom.DenCompany.SimpleApplication.entity.custom.LogPredicatesBuilder;
import nocom.DenCompany.SimpleApplication.repository.LogRepository;
import nocom.DenCompany.SimpleApplication.service.logService.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping("log/list")
    public List<Log> list() {
        return logService.getAll();
    }

    @GetMapping("log/parametrizedList")
    @ResponseBody
    public Iterable<Log> parametrizedList(@RequestParam(value = "search") String search){
        return logService.getFetchedList(search);
    }
}
