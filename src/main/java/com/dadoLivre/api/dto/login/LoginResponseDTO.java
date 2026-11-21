package com.dadoLivre.api.dto.login;

import lombok.Data;

@Data 
public class LoginResponseDTO {
    private String accessToken;

    public LoginResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}
