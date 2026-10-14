package com.exemplo.repository;

import com.exemplo.model.Seguindo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguindoRepository extends JpaRepository<Seguindo, Integer> {
}