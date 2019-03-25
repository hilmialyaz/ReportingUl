package com.huobi.reportingweb.controller;

import com.huobi.reportingweb.dto.LoginResponse;
import com.huobi.reportingweb.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginControllerTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void whenLoginRequest_LoggedIn(){
        LoginResponse response = loginService.login("demo@bumin.com.tr","cjaiU8CV");
    }


}