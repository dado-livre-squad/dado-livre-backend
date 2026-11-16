package com.dadoLivre.api.service;

import com.dadoLivre.api.model.entities.EncarregadoDados;
import com.dadoLivre.api.repository.EncarregadoDadosRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.UUID;

@Service
public class EncarregadoDadosService {

    public final EncarregadoDadosRepository repository;

    EncarregadoDadosService(EncarregadoDadosRepository repository) {
        this.repository = repository;
    }

    public List<EncarregadoDados> findAll() {
        return this.repository.findAll();
    }

    public EncarregadoDados findById(UUID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Encarregado de dados não encontrado"));
    }
}
