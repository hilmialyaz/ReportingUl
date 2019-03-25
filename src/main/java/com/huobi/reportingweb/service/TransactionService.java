package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Date;

@Service
public class TransactionService {
    @Value("${sandbox.client.url}")
    private String reportingServerUrl;

    RestTemplate restTemplate;

    public TransactionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TransactionReportResponse reportTransaction(TransactionReportRequest request,String token) {
        HttpEntity<?> httpEntity = getHttpEntity(request, token);
        ResponseEntity<TransactionReportResponse> response = restTemplate.postForEntity(reportingServerUrl+"/v3/transactions/report", httpEntity, TransactionReportResponse.class);
        return response.getBody();
    }

    public TransactionResponse getTransaction(TransactionRequest request, String token) {
        HttpEntity<?> httpEntity = getHttpEntity(request, token);
        ResponseEntity<TransactionResponse> response = restTemplate.postForEntity(reportingServerUrl+"/v3/transaction", httpEntity, TransactionResponse.class);
        return response.getBody();
    }

    private HttpEntity<?> getHttpEntity(Object request, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        return new HttpEntity<Object>(request,headers);
    }
}
