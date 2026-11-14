package com.dadoLivre.api.controller;

import com.dadoLivre.api.dto.candidato.CandidatoResponseDTO;
import com.dadoLivre.api.service.CandidatoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/candidato")
public class CandidatoController {

    @Autowired
    public CandidatoService service;

    @GetMapping()
    public List<CandidatoResponseDTO> listarCandidatos() {
        return this.service.listarCandidatos();
    }
}
