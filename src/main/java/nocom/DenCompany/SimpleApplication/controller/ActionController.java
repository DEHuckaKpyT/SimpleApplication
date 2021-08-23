package nocom.DenCompany.SimpleApplication.controller;

import lombok.RequiredArgsConstructor;
import nocom.DenCompany.SimpleApplication.Parser;
import nocom.DenCompany.SimpleApplication.controller.dto.StringOfDigitsDto;
import nocom.DenCompany.SimpleApplication.service.actionService.ActionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActionController {

    private final ActionService actionService;

    @GetMapping("action/doAll")
    public List<String> doAllActions(@RequestBody StringOfDigitsDto dto) {
        return actionService.doAll(Parser.getDigitsByString(dto.getDigits()));
    }
}
