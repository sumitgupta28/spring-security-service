package com.security.spring.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Represents a TransactionRequest", title = "TransactionRequest")
public class TransactionRequest {
    @Schema(description = "Unique identifier of the Transaction", example = "asd879asua8s7dkjhskd")
    private String transactionId;
    @Schema(description = "Transaction Amount", example = "10.17")
    private String transactionAmount;
    @Schema(description = "Token Associated with Transaction ", example = "GHJHGI8778970808GHHJGJ")
    private String transactionToken;

}
