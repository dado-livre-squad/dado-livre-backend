package com.dadoLivre.api.repository;

import com.dadoLivre.api.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SituacaoRepository extends JpaRepository<Situacao, UUID> {
}
