package com.exemplo.repository;

import com.exemplo.model.EncarregadoDados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncarregadoDadosRepository extends JpaRepository<EncarregadoDados, String> {
}