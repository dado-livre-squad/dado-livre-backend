package com.exemplo.repository;

import com.exemplo.model.Coligacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColigacaoRepository extends JpaRepository<Coligacao, String> {
}