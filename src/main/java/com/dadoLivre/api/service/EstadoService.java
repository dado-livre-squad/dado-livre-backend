package com.dadoLivre.api.service;

import com.dadoLivre.api.model.Estado;
import com.dadoLivre.api.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    public EstadoRepository repository;

    public List<Estado> findAll() {
        return this.repository.findAll();
    }
}
