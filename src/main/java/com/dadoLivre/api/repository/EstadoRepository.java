package com.dadoLivre.api.repository;

import com.dadoLivre.api.dto.estado.EstadoViewProjection;
import com.dadoLivre.api.model.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EstadoRepository extends JpaRepository<Estado, UUID> {

    @Query(value = "SELECT * FROM listarEstados", nativeQuery = true)
    List<EstadoViewProjection> listarEstados();
}