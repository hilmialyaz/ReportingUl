package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.LoginRequest;
import com.huobi.reportingweb.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    private RestTemplate  restTemplate;

    @Value("${sandbox.client.url}")
    private String reportingServerUrl;

    public LoginService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LoginResponse login(String userName, String password) {
        ResponseEntity<LoginResponse> response = restTemplate.postForEntity(reportingServerUrl+"/v3/merchant/user/login", new LoginRequest(userName, password), LoginResponse.class);
        return response.getBody();
    }
}
