package com.dadoLivre.api.repository;

import com.dadoLivre.api.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstadoRepository extends JpaRepository<Estado, UUID> {
}
