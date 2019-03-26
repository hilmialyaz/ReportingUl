package com.huobi.reportingweb.service;

import com.huobi.reportingweb.dto.GetClientInfoRequest;
import com.huobi.reportingweb.dto.GetClientInfoResponse;
import com.huobi.reportingweb.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.huobi.reportingweb.util.HttpUtils.getHttpEntity;
@Service
public class ClientInformationService {

    private RestTemplate restTemplate;

    @Value("${sandbox.client.url}")
    private String reportingServerUrl;

    public ClientInformationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public GetClientInfoResponse getClientInfo(GetClientInfoRequest request,String token) {
        HttpEntity<?> httpEntity = getHttpEntity(request, token);
        ResponseEntity<GetClientInfoResponse> response = restTemplate.postForEntity(reportingServerUrl+"/v3/transaction",httpEntity,GetClientInfoResponse.class);
        return response.getBody();
    }
}
