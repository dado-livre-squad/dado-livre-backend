package com.dadoLivre.api.dto.usuario;

import com.dadoLivre.api.model.enums.TipoUsuario;

public record UsuarioResponseDTO(
    String nome, 
    String sobrenome,
    String email, 
    TipoUsuario tipo
) {}
