package com.dadoLivre.api.repository;

import com.dadoLivre.api.model.entities.EncarregadoDados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EncarregadoDadosRepository extends JpaRepository<EncarregadoDados, UUID> {
}
