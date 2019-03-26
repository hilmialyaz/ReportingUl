package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenHandlerService {


    @Value("${sandbox.client.email}")
    private String reportingServerEmail;

    @Value("${sandbox.client.password}")
    private String reportingServerPass;


    private LoginService loginService;

    public TokenHandlerService(LoginService loginService) {
        this.loginService = loginService;
    }

    private Optional<String> token = Optional.ofNullable(null);

    public String getServiceToken() {
        return  token.orElseGet(()-> {
            LoginResponse response = loginService.login(reportingServerEmail, reportingServerPass).orElseThrow(() -> new RuntimeException(""));
            token = Optional.ofNullable(response.getToken());
            return token.get();
        });
    }



}
