package com.dadoLivre.api.dto.estado;

import java.util.UUID;

public interface EstadoViewProjection {
    UUID getId();
    String getNome();
    String getSigla();
}