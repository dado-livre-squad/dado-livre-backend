package com.dadoLivre.api.dto.usuario;

import lombok.Data;

@Data 
public class UsuarioByEmailResponseDTO {
    private String email;
    private String senha;
}
