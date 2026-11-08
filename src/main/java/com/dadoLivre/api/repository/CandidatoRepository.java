package com.dadoLivre.api.repository;

import com.dadoLivre.api.model.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidatoRepository extends JpaRepository<Candidato, UUID> {
}
