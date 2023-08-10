package com.army.armytiger.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Component
public class OpenApiMapper {
    private final String base_url = "https://opendata.mnd.go.kr/";
    private final String key = "3337313639343235303733323532303934/";
    private final String next = "/json/DS_AMRSV_TRNGCMP_RGHMAP/1/5/";

    private String makeUrl() throws UnsupportedEncodingException {
        return base_url + key + next;
    }

    public ResponseEntity<?> fetch() throws UnsupportedEncodingException {
        System.out.println(makeUrl());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl(), HttpMethod.GET, entity, Map.class);
        System.out.println(resultMap.getBody());
        return resultMap;
    }
}
