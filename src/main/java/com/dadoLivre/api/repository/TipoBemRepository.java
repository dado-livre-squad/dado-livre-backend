package com.exemplo.repository;

import com.exemplo.model.TipoBem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoBemRepository extends JpaRepository<TipoBem, String> {
}