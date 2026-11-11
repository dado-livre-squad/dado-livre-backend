package com.dadoLivre.api.repository;

import com.dadoLivre.api.dto.partido.PartidoProjection;
import com.dadoLivre.api.model.entities.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PartidoRepository extends JpaRepository<Partido, UUID> {
}
