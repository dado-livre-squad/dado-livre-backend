package com.dadoLivre.api.dto.partido;

import java.util.UUID;

public interface PartidoProjection {
    UUID getId();
    String getNome();
    String getSigla();
    Integer getNumero();
}
