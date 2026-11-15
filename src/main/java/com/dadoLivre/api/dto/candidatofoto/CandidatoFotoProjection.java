package com.dadoLivre.api.dto.candidatofoto;

import java.util.UUID;

public interface CandidatoFotoProjection {
    public UUID getId();
    public byte[] getFoto();
    public String getTipo();
}
