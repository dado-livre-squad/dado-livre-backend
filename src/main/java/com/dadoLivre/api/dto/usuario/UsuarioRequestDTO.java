package com.dadoLivre.api.dto.usuario;

import com.dadoLivre.api.model.enums.TipoUsuario;

import lombok.Data;

@Data 
public class UsuarioRequestDTO {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private TipoUsuario tipo; 
}
