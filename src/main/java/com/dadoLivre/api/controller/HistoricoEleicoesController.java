package com.dadoLivre.api.controller;

import com.dadoLivre.api.model.entities.HistoricoEleicoes;
import com.dadoLivre.api.service.HistoricoEleicoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/historico-eleicoes")
public class HistoricoEleicoesController {

    @Autowired
    public HistoricoEleicoesService service;

    @GetMapping("v1")
    public List<HistoricoEleicoes> findAll() {
        return this.service.findAll();
    }
}
