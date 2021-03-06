package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static com.huobi.reportingweb.util.HttpUtils.getHttpEntity;

@Service
public class TransactionService {
    @Value("${sandbox.client.url}")
    private String reportingServerUrl;

    RestTemplate restTemplate;

    public TransactionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<TransactionReportResponse> reportTransaction(TransactionReportRequest request, String token) {
        HttpEntity<?> httpEntity = getHttpEntity(request, token);
        ResponseEntity<TransactionReportResponse> response = restTemplate.postForEntity(reportingServerUrl+"/v3/transactions/report", httpEntity, TransactionReportResponse.class);
        return Optional.ofNullable(response.getBody());
    }

    public Optional<TransactionResponse> getTransaction(TransactionRequest request, String token) {
        HttpEntity<?> httpEntity = getHttpEntity(request, token);
        ResponseEntity<TransactionResponse> response = restTemplate.postForEntity(reportingServerUrl+"/v3/transaction", httpEntity, TransactionResponse.class);
        return Optional.ofNullable(response.getBody());
    }


}
