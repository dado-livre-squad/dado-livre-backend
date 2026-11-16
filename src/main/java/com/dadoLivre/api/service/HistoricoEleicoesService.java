package com.dadoLivre.api.service;

import com.dadoLivre.api.model.entities.HistoricoEleicoes;
import com.dadoLivre.api.repository.HistoricoEleicoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoEleicoesService {

    public final HistoricoEleicoesRepository repository;

    HistoricoEleicoesService(HistoricoEleicoesRepository repository) {
        this.repository = repository;
    }

    public List<HistoricoEleicoes> findAll() {
        return this.repository.findAll();
    }
}
