package com.dadoLivre.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dadoLivre.api.dto.candidatofoto.CandidatoFotoProjection;
import com.dadoLivre.api.model.entities.CandidatoFoto;

public interface CandidatoFotoRepository extends JpaRepository<CandidatoFoto, UUID> {
    @Query(value = "SELECT * FROM fotoCandidato(:idCandidato)", nativeQuery = true)
   Optional<CandidatoFotoProjection> fotoCandidato(@Param("idCandidato") UUID fotoId);
}
