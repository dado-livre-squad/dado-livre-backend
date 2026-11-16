package com.dadoLivre.api.controller;

import com.dadoLivre.api.model.entities.TipoBem;
import com.dadoLivre.api.service.TipoBemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-bem")
public class TipoBemController {

    public final TipoBemService service;

    TipoBemController(TipoBemService service) {
        this.service = service;
    }

    @GetMapping("/v1")
    public List<TipoBem> findAll() {
        return this.service.findAll();
    }
}
