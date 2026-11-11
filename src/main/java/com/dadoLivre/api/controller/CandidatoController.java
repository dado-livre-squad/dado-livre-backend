package com.dadoLivre.api.controller;

import com.dadoLivre.api.model.entities.Candidato;
import com.dadoLivre.api.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/candidato")
public class CandidatoController {

    @Autowired
    public CandidatoService service;

    @GetMapping("v1")
    public List<Candidato> findAll() {
        return this.service.findAll();
    }
}
