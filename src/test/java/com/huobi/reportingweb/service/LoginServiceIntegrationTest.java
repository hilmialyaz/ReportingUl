package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.LoginResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginServiceIntegrationTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void whenLoginRequest_LoggedIn(){
        LoginResponse response = loginService.login("demo@bumin.com.tr","cjaiU8CV");
        assertThat(response).isNotNull().matches(x-> x.getStatus().equals("APPROVED"));
    }


}