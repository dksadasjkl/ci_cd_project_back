package com.project.pet.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthCheckController {

    @Value("${server.env}") // yml 파일의 해당 값 가져오기
    private String env;
    @Value("${server.name}")
    private String serverName;
    @Value("${server.deploy-address}")
    private String deployAddress;
    @Value("${server.port}")
    private String port;

    // 서버가 잘 실행되고 있는지
    @GetMapping("/server/hc")
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok(
                Map.of(
                        "serverName", serverName,
                        "deployAddress", deployAddress,
                        "port", port
                )
        );
    }

    // 서버가 green 인지 blue 인지
    @GetMapping("/server/env")
    public ResponseEntity<?> getEnv() {
        return ResponseEntity.ok(env);
    }

}
