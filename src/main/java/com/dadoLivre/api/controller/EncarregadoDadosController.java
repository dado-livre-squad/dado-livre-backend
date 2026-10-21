package com.dadoLivre.api.controller;

import com.dadoLivre.api.model.EncarregadoDados;
import com.dadoLivre.api.service.EncarregadoDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/encarregado-dados")
public class EncarregadoDadosController {

    @Autowired
    public EncarregadoDadosService service;

    @GetMapping("v1")
    public List<EncarregadoDados> findAll() {
        return this.service.findAll();
    }

    @GetMapping("v1/{id}")
    public EncarregadoDados findById(@PathVariable("id") UUID id) {
        return this.service.findById(id);
    }
}
