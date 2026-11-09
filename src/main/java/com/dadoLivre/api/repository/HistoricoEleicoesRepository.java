package com.dadoLivre.api.repository;

import com.dadoLivre.api.model.entities.HistoricoEleicoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HistoricoEleicoesRepository extends JpaRepository<HistoricoEleicoes, UUID> {
}
