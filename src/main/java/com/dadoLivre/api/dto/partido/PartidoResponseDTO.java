package com.dadoLivre.api.dto.partido;

import java.util.UUID;

public record PartidoResponseDTO(UUID id, String nome, String sigla, Integer numero) {
}
