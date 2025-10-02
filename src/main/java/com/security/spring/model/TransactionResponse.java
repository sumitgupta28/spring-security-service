package com.security.spring.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Schema(description = "Represents a TransactionResponse", title = "TransactionResponse")
public class TransactionResponse {
    @Schema(description = "Unique identifier of the Transaction", example = "asd879asua8s7dkjhskd")
    private String transactionId;
    @Schema(description = "status of the Transaction", example = "APPROVED")
    private String transactionStatus;
}
