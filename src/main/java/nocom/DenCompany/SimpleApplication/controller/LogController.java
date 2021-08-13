package nocom.DenCompany.SimpleApplication.controller;

import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.service.logService.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController {
    LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("log/list")
    public List<Log> list() {
        return logService.getAll();
    }

    @GetMapping("log/parametrizedList")
    public List<Log> parametrizedList(@RequestParam(value = "search") String search){
        return logService.getFetchedList(search);
    }
}
