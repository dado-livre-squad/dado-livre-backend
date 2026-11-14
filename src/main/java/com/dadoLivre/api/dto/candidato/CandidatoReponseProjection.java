package com.dadoLivre.api.dto.candidato;

import java.util.UUID;

public interface CandidatoReponseProjection {
    public UUID getIdcandidato();
    public String getNomesocial();
    public String getFoto();
    public UUID getCargoid();
    public String getNomeCargo();
    public UUID getPartidoid();
    public String getSiglapartido();
    public String getNomepartido();
    public Integer getNumeropartido();
}
