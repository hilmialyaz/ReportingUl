package com.huobi.reportingweb.controller;

import com.huobi.reportingweb.ReportingwebApplication;
import com.huobi.reportingweb.exception.RestExceptionHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReportingwebApplication.class)
public class TransactionResourceControllerIntTest {

    private MockMvc mockMvc;

    @Autowired
    TransactionResourceController controller;

    @Autowired
    RestExceptionHandler restExceptionHandler;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(this.controller)
                .setControllerAdvice(restExceptionHandler).build();
    }


    @Test
    public void getTransactionReport() throws Exception {
        mockMvc.perform(get("/api/transaction-reports?start={startDate}&end={endDate}","2015-07-01","2019-10-01" ))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.status").value("APPROVED"));
    }


}