package com.dadoLivre.api.repository;

import com.dadoLivre.api.dto.candidato.CandidatoReponseProjection;
import com.dadoLivre.api.model.entities.Candidato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CandidatoRepository extends JpaRepository<Candidato, UUID> {

    @Query(
        value = "SELECT * FROM listarCandidatos",
        nativeQuery = true
    )
    public List<CandidatoReponseProjection> listarCandidatos();
}
