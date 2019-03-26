package com.huobi.reportingweb.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class HttpUtils {
    public static HttpEntity<?> getHttpEntity(Object request, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        return new HttpEntity<Object>(request,headers);
    }
}
