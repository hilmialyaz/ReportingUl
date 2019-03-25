package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.*;
import com.huobi.reportingweb.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private TransactionService service;

    @Autowired
    LoginService loginService;


    @Test
    public void whenRequestReport_ReportExists() throws IOException {
        TransactionReportResponse trxResp = JsonUtils.jsonFile2Object("transactionreport_resp.json", TransactionReportResponse.class);
        when(restTemplate.postForEntity(anyString(), any(HttpEntity.class),Matchers.<Class<TransactionReportResponse>>any())).thenReturn(new ResponseEntity<>(trxResp,HttpStatus.OK));
        TransactionReportResponse resp = service.reportTransaction(new TransactionReportRequest("2015-07-01","2019-03-01"),null);
        assertThat(resp).isNotNull().matches(x->"APPROVED".equals(x.getStatus())
                && x.getResponse().size()== trxResp.getResponse().size() );
        assertThat(resp).isEqualToComparingFieldByFieldRecursively(trxResp);
    }


    @Test
    public void whenTransactionRequested_TransactionReturn() throws IOException {
        TransactionResponse trxResp = JsonUtils.jsonFile2Object("get_transaction_resp.json", TransactionResponse.class);
        when(restTemplate.postForEntity(anyString(), any(HttpEntity.class),Matchers.<Class<TransactionResponse>>any())).thenReturn(new ResponseEntity<>(trxResp,HttpStatus.OK));
        TransactionResponse resp = service.getTransaction(new TransactionRequest("1010992-1539329625-1293"),null);
        assertThat(resp).isEqualToComparingFieldByFieldRecursively(trxResp);
    }
}