package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.GetClientInfoRequest;
import com.huobi.reportingweb.dto.GetClientInfoResponse;
import com.huobi.reportingweb.dto.TransactionResponse;
import com.huobi.reportingweb.util.JsonUtils;
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

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientInformationServiceTest {

    @MockBean
    RestTemplate restTemplate;

    @Autowired
    private  ClientInformationService clientInformationService;

    @Test
    public void whenTransactionIdTrue_ReturnClientInfo() throws IOException {
        GetClientInfoResponse trxResp = JsonUtils.jsonFile2Object("get_clientinfo_resp.json", GetClientInfoResponse.class);
        when(restTemplate.postForObject(anyString(), any(HttpEntity.class),any())).thenReturn(trxResp);
        Optional<GetClientInfoResponse> clientInfo = clientInformationService.getClientInfo(new GetClientInfoRequest(""), "");
        assertThat(clientInfo.get()).isEqualToComparingFieldByFieldRecursively(trxResp);
    }
}