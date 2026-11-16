package com.dadoLivre.api.service;

import com.dadoLivre.api.exception.ResourceNotFoundException;
import com.dadoLivre.api.model.entities.Situacao;
import com.dadoLivre.api.repository.SituacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SituacaoService {

    public final SituacaoRepository repository;

    SituacaoService(SituacaoRepository repository) {
        this.repository = repository;
    }

    public List<Situacao> findAll() {
        return this.repository.findAll();
    }

    public Situacao findById(UUID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Situação não encontrada"));
    }
}
