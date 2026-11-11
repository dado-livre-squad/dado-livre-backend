package com.dadoLivre.api.service;

import com.dadoLivre.api.exception.ResourceNotFoundException;
import com.dadoLivre.api.model.entities.Partido;
import com.dadoLivre.api.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PartidoService {

    @Autowired
    public PartidoRepository repository;

    public List<Partido> findAll() {
        return this.repository.findAll();
    }

    public Partido findById(UUID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partido não encontrado."));
    }
}
