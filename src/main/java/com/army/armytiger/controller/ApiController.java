package com.army.armytiger.controller;

import com.army.armytiger.api.OpenApiMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiController {

    private final OpenApiMapper openApiMapper;

    @GetMapping("/open-api")
    public ResponseEntity<?> fetch() throws UnsupportedEncodingException{
        ResponseEntity<?> apiResponse = openApiMapper.fetch();

        if(apiResponse.getStatusCode().is2xxSuccessful()){
            Map<?, ?> responseData = (Map<?, ?>) apiResponse.getBody();
            log.info("Json DATa: {}", responseData);
            return ResponseEntity.ok("성공!");
        } else {
            return ResponseEntity.badRequest().body("실패");
        }
    }

}
