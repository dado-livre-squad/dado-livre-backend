package com.dadoLivre.api.service;

import com.dadoLivre.api.model.entities.HistoricoEleicoes;
import com.dadoLivre.api.repository.HistoricoEleicoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoEleicoesService {

    @Autowired
    public HistoricoEleicoesRepository repository;

    public List<HistoricoEleicoes> findAll() {
        return this.repository.findAll();
    }
}
