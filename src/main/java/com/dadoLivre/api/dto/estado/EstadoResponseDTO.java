package com.dadoLivre.api.dto.estado;

import java.util.UUID;

public record EstadoResponseDTO(UUID id, String nome, String sigla) {}