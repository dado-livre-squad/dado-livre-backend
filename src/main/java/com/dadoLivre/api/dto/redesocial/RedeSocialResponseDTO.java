package com.dadoLivre.api.dto.redesocial;

import java.util.UUID;

public record RedeSocialResponseDTO(
    UUID id,
    String endereco,
    String nome,
    String usuario
) {}
