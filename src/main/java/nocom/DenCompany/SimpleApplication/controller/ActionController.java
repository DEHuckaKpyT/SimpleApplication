package nocom.DenCompany.SimpleApplication.controller;

import nocom.DenCompany.SimpleApplication.Parser;
import nocom.DenCompany.SimpleApplication.service.actionService.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActionController {

    @Autowired
    ActionService actionService;

    @GetMapping("action/doAll")
    public List<String> doAllActions(@RequestParam(value = "digits") String digits ){
        return actionService.doAll(Parser.getDigitsByString(digits));
    }
}
