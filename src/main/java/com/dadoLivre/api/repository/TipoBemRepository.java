package com.dadoLivre.api.repository;

import com.dadoLivre.api.model.TipoBem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoBemRepository extends JpaRepository<TipoBem, UUID> {
}
