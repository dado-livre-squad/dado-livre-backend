package com.dadoLivre.api.dto.candidato;

import java.util.UUID;

public interface CandidateDetailsProjection {
    public UUID getId();
    public String getNomesocial();
    public String getSobre();
    public Integer getIdade();
    public String getEstado();
    public String getPartido();
    public Integer getNumeropartido();
    public String getcargo();
    public String getTipoCargo();
}
