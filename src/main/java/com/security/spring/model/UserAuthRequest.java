package com.security.spring.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Represents a UserAuthRequest", title = "UserAuthRequest")
public class UserAuthRequest {

    private String userName;
    private String password;

}
