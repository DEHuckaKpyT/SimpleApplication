package nocom.DenCompany.SimpleApplication.controller;

import com.github.database.rider.core.api.dataset.DataSet;
import com.jupiter.tools.spring.test.postgres.annotation.meta.EnablePostgresIntegrationTest;
import com.querydsl.core.support.FetchableQueryBase;
import nocom.DenCompany.SimpleApplication.entity.Log;
import nocom.DenCompany.SimpleApplication.repository.LogRepository;
import nocom.DenCompany.SimpleApplication.service.logService.LogService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.shaded.javax.ws.rs.core.MediaType;

import java.util.Date;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LogController.class)
class LogControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    LogService logService;

    //TODO что-то мне не нравятся эти тесты. кажется, нужно по-другому
    @Test
    void list() throws Exception {
        //arrange
        List<Log> logs = Lists.list(Log.builder().inputValue("123").result("Max = 3").build());
        given(logService.getAll()).willReturn(logs);
        //act & assert
        mockMvc.perform(MockMvcRequestBuilders
                .get("/log/list")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].inputValue").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].result").value("Max = 3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].inputValue").doesNotExist());
    }

    @Test
    void parametrizedList() throws Exception {
        //arrange
        List<Log> logs = Lists.list(
                Log.builder().inputValue("123").result("Max = 3").build(),
                Log.builder().inputValue("123").result("Min = 1").build());
        given(logService.getFetchedList("result:Min = 1")).willReturn(logs);
        //act & assert
        mockMvc.perform(MockMvcRequestBuilders
                .get("/log/parametrizedList")
                .param("search", "result:Min = 1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].inputValue").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].result").value("Max = 3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].inputValue").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].result").value("Min = 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].inputValue").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].result").doesNotExist());
    }
}