package com.security.spring.controller;

import com.security.spring.model.TransactionRequest;
import com.security.spring.model.TransactionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/api")
@RequiredArgsConstructor
@Tag(name = "Transaction API")
public class TransactionController {


    @PostMapping
    @Operation(description = "Validate the Store the Transaction")
    public ResponseEntity<TransactionResponse> processTransaction(@RequestBody TransactionRequest transactionRequest) {
        TransactionResponse transactionResponse = TransactionResponse.builder().transactionId(transactionRequest.getTransactionId()).transactionStatus("APPROVED").build();
        return ResponseEntity.ok(transactionResponse);
    }

}
