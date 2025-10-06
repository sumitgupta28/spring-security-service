package com.security.spring.controller;

import com.security.spring.model.UserAuthRequest;
import com.security.spring.service.JwtTokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@RestController
@Tag(name = "Authenticate API")
public class AuthenticateController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenService jwtTokenService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> generateToken(@RequestBody UserAuthRequest userAuthRequest) throws NoSuchAlgorithmException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userAuthRequest.getUserName(), userAuthRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(jwtTokenService.generateToken(userAuthRequest.getUserName()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UNAUTHORIZED");
    }

}
