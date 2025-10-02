package com.security.spring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/health")
@Tag(name = "HealthCheck API")

public class HealthCheckController {


    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Status Up");
    }
}
