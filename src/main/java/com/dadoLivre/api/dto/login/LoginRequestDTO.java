package com.dadoLivre.api.dto.login;

import lombok.Data;

@Data 
public class LoginRequestDTO {
    private String email;
    private String senha;
}
