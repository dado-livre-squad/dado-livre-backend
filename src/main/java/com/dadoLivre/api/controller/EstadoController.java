package com.dadoLivre.api.controller;

import com.dadoLivre.api.model.Estado;
import com.dadoLivre.api.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/estado")
public class EstadoController {

    @Autowired
    public EstadoService service;

    @GetMapping("/v1")
    public List<Estado> findAll() {
        return this.service.findAll();
    }
}
