package com.dadoLivre.api.service;

import com.dadoLivre.api.model.entities.Candidato;
import com.dadoLivre.api.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    public CandidatoRepository repository;

    public List<Candidato> findAll() {
        return this.repository.findAll();
    }
}
