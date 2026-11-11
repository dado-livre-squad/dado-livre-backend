package com.dadoLivre.api.controller;

import com.dadoLivre.api.model.entities.Partido;
import com.dadoLivre.api.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/partido")
public class PartidoController {

    @Autowired
    public PartidoService service;

    @GetMapping("v1")
    public List<Partido> findAll() {
        return this.service.findAll();
    }

    @GetMapping("v1/{id}")
    public Partido findById(@PathVariable("id") UUID id) {
        return this.service.findById(id);
    }
}
