package com.dadoLivre.api.service;

import com.dadoLivre.api.model.TipoBem;
import com.dadoLivre.api.repository.TipoBemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoBemService {

    @Autowired
    public TipoBemRepository repository;

    public List<TipoBem> findAll() {
        return this.repository.findAll();
    }
}
