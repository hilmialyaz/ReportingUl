package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.LoginResponse;
import com.huobi.reportingweb.dto.TransactionReportRequest;
import com.huobi.reportingweb.dto.TransactionReportResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionServiceIntegrationTest {

    @Autowired
    TransactionService service;

    @Autowired
    LoginService loginService;

    private  String token;

    @Before
    public void setUp() throws Exception {
        LoginResponse response = loginService.login("demo@bumin.com.tr","cjaiU8CV");
        if(response==null || !"APPROVED".equals(response.getStatus()))
            throw new IllegalAccessException();
        token = response.getToken();
    }


    @Test
    public void whenRequestReport_ReportExists(){
        TransactionReportResponse resp = service.reportTransaction(new TransactionReportRequest("2015-07-01","2019-03-01"),token);
        assertThat(resp).isNotNull().matches(x->"APPROVED".equals(x.getStatus()) && x.getResponse().size()>0 );
    }
}