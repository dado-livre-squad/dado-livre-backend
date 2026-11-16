package com.dadoLivre.api.controller;

import com.dadoLivre.api.model.entities.Situacao;
import com.dadoLivre.api.service.SituacaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/situacao")
public class SituacaoController {

    public final SituacaoService service;

    SituacaoController(SituacaoService service) {
        this.service = service;
    }

    @GetMapping("v1")
    public List<Situacao> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/v1/{id}")
    public Situacao findById(@PathVariable("id") UUID id) {
        return this.service.findById(id);
    }
}
