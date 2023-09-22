package com.mps.batch_mps_pushdata.controller;

import com.mps.batch_mps_pushdata.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push")
public class PushController {
    private static final String ALLOW_HEADERS_METHODS = "GET, POST, DELETE, PUT, OPTIONS, HEAD";
    @Autowired
    private PushService service;
    @GetMapping("/pushData")
    @ResponseBody
    public ResponseEntity<?> getEmpList(){
        service.pushData();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"*");
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,ALLOW_HEADERS_METHODS);
        return ResponseEntity.noContent().headers(headers).build();
    }
}
