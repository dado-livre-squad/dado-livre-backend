package com.dadoLivre.api.dto.partido;

import lombok.Data;

public class PartidoResponseDto {
    @Data
    public class PartidoResponseDTO {
        private String id;
        private String nome;
        private String sigla;
        private Integer numero;
    }
}
