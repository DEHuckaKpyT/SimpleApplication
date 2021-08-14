package nocom.DenCompany.SimpleApplication.controller;

import nocom.DenCompany.SimpleApplication.controller.dto.StringOfDigitsDto;
import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.service.actionService.ActionService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.web.SpringBootMockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.javax.ws.rs.core.MediaType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ActionController.class)
class ActionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ActionService actionService;

    @Test
    void doAllActions() throws Exception {
        //arrange
        given(actionService.doAll(Lists.list(1, 2, 3))).willReturn(
                Lists.list("Average = 2.0", "Max = 3", "Min = 1", "Sum = 6"));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/action/doAll")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"digits\":123}")
                .contentType(MediaType.APPLICATION_JSON);
        //act & assert
        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("Average = 2.0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("Max = 3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2]").value("Min = 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3]").value("Sum = 6"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[4]").doesNotExist());
    }
}