package com.exemplo.repository;

import com.exemplo.model.HistoricoEleitoral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoEleitoralRepository extends JpaRepository<HistoricoEleitoral, Integer> {
}