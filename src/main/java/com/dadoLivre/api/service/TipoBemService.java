package com.dadoLivre.api.service;

import com.dadoLivre.api.model.entities.TipoBem;
import com.dadoLivre.api.repository.TipoBemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoBemService {

    public final TipoBemRepository repository;

    TipoBemService(TipoBemRepository repository) {
        this.repository = repository;
    }

    public List<TipoBem> findAll() {
        return this.repository.findAll();
    }
}
