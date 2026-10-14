package com.exemplo.repository;

import com.exemplo.model.Bens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BensRepository extends JpaRepository<Bens, String> {
}