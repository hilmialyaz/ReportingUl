package com.huobi.reportingweb.controller;

import com.huobi.reportingweb.ReportingwebApplication;
import com.huobi.reportingweb.dto.*;
import com.huobi.reportingweb.exception.RestExceptionHandler;
import com.huobi.reportingweb.service.TokenHandlerService;
import com.huobi.reportingweb.service.TransactionService;
import com.huobi.reportingweb.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReportingwebApplication.class)
public class TransactionResourceControllerTest {

    private MockMvc mockMvc;

    @Autowired
    TransactionResourceController controller;

    @Autowired
    RestExceptionHandler restExceptionHandler;

    @MockBean
    TokenHandlerService tokenHandlerService;

    @MockBean
    TransactionService transactionService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(this.controller)
                .setControllerAdvice(restExceptionHandler).build();
    }


    @Test
    public void getTransactionReport() throws Exception {
        TransactionReportResponse trxResp = JsonUtils.jsonFile2Object("transactionreport_resp.json", TransactionReportResponse.class);
        when(tokenHandlerService.getServiceToken()).thenReturn("Token");
        when(transactionService.reportTransaction(any(TransactionReportRequest.class),any(String.class))).thenReturn(Optional.ofNullable(trxResp));
        mockMvc.perform(get("/api/transaction-reports?start={startDate}&end={endDate}","2015-07-01","2019-10-01" ))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.status").value("APPROVED"));
    }


    @Test
    public void getTransactionWithTransactionId() throws Exception {
        TransactionResponse trxResp = JsonUtils.jsonFile2Object("get_transaction_resp.json", TransactionResponse.class);

        when(tokenHandlerService.getServiceToken()).thenReturn("Token");
        when(transactionService.getTransaction(any(TransactionRequest.class),any(String.class))).thenReturn(Optional.ofNullable(trxResp));

        Merchant_ merchant = trxResp.getTransaction().getMerchant();
        mockMvc.perform(get("/api/transactions/{transactionId}", "1010992-1539329625-1293" ))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.transaction.merchant.id").value(merchant.getId().intValue()))
                .andExpect(jsonPath("$.transaction.merchant.referenceNo").value(merchant.getReferenceNo()))
                .andExpect(jsonPath("$.transaction.merchant.status").value(merchant.getStatus()))
                .andExpect(jsonPath("$.transaction.merchant.operation").value(merchant.getOperation()))
                .andExpect(jsonPath("$.transaction.merchant.type").value(merchant.getType()))
                .andExpect(jsonPath("$.transaction.merchant.transactionId").value(merchant.getTransactionId()));
    }

    @Test
    public void getTransactionWithTransactionId_NotFound() throws Exception {
        TransactionResponse trxResp = new TransactionResponse();
        trxResp.setStatus("DECLINED");

        when(tokenHandlerService.getServiceToken()).thenReturn("Token");
        when(transactionService.getTransaction(any(TransactionRequest.class),any(String.class))).thenReturn(Optional.ofNullable(trxResp));

        mockMvc.perform(get("/api/transactions/{transactionId}", "1010992-1539329625-1293" ))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.status").value("NOT_FOUND"));
    }


}