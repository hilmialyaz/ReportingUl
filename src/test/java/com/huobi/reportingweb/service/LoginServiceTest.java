package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.LoginRequest;
import com.huobi.reportingweb.dto.LoginResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @MockBean
    private RestTemplate template;


    @Test
    public void whenLoginRequest_LoggedIn(){
        when(template.postForEntity(any(String.class), new LoginRequest(any(),any()), LoginResponse.class)).thenReturn(new ResponseEntity(new LoginResponse("123","APPROVED"),HttpStatus.OK));
        LoginResponse response = loginService.login("","");
        assertThat(response).isNotNull().matches(x-> x.getStatus().equals("APPROVED"));
    }


    @Test
    public void whenUserPassUncorrect_Disapproved(){
        when(template.postForEntity(any(String.class), new LoginRequest(any(),any()), LoginResponse.class)).thenReturn(new ResponseEntity(new LoginResponse("123","DECLINED"),HttpStatus.OK));
        LoginResponse response = loginService.login("","");
        assertThat(response).isNotNull().matches(x-> x.getStatus().equals("DECLINED"));
    }


}