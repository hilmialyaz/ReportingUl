package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.*;
import com.huobi.reportingweb.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
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
    TokenHandlerService tokenHandlerService;

    private  String token;

    @Before
    public void setUp() throws Exception {
        token = tokenHandlerService.getServiceToken();
    }


    @Test
    public void whenRequestReport_ReportExists(){
        TransactionReportResponse resp = service.reportTransaction(new TransactionReportRequest("2015-07-01","2019-03-01"),token);
        assertThat(resp).isNotNull().matches(x->"APPROVED".equals(x.getStatus()) && x.getResponse().size()>0 );
    }

    @Test
    public void whenRequestTransaction_ReturnTransaction() throws IOException {
        TransactionResponse trxResp = JsonUtils.jsonFile2Object("get_transaction_resp.json", TransactionResponse.class);
        TransactionResponse resp = service.getTransaction(new TransactionRequest(trxResp.getTransaction().getMerchant().getTransactionId()),token);
        assertThat(resp).isEqualToComparingFieldByFieldRecursively(trxResp);
    }



}