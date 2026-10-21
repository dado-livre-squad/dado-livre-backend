package com.dadoLivre.api.repository;

import com.dadoLivre.api.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartidoRepository extends JpaRepository<Partido, UUID> {
}
