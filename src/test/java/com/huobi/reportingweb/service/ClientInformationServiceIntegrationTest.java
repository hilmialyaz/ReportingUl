package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.GetClientInfoRequest;
import com.huobi.reportingweb.dto.GetClientInfoResponse;
import com.huobi.reportingweb.dto.LoginResponse;
import com.huobi.reportingweb.dto.TransactionResponse;
import com.huobi.reportingweb.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientInformationServiceIntegrationTest {

    @Autowired
    private ClientInformationService clientInformationService;

    @Autowired
    private LoginService loginService;

    private  String token;

    @Before
    public void setUp() throws Exception {
        LoginResponse response = loginService.login("demo@bumin.com.tr","cjaiU8CV");
        if(response==null || !"APPROVED".equals(response.getStatus()))
            throw new IllegalAccessException();
        token = response.getToken();
    }

    @Test
    public void getCustomerDetails_WithTransactionId() throws IOException {
        GetClientInfoResponse trxResp = JsonUtils.jsonFile2Object("get_clientinfo_resp.json", GetClientInfoResponse.class);
        GetClientInfoResponse clientInfo = clientInformationService.getClientInfo(new GetClientInfoRequest(""), token);
        assertThat(clientInfo).isEqualToComparingFieldByFieldRecursively(trxResp);
    }
}
