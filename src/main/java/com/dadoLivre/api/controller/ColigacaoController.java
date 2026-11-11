package com.dadoLivre.api.controller;

import com.dadoLivre.api.dto.partido.PartidoRequestDTO;
import com.dadoLivre.api.dto.partido.PartidoResponseDTO;
import com.dadoLivre.api.model.entities.Coligacao;
import com.dadoLivre.api.service.ColigacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/coligacao")
public class ColigacaoController {

    @Autowired
    public ColigacaoService service;

    @GetMapping("v1")
    public List<Coligacao> findAll() {
        return this.service.findAll();
    }

    @GetMapping("v1/{id}/partidos")
    public List<PartidoResponseDTO> listarPartidosDaColigacao(@PathVariable("id") UUID idColigacao) {
        return this.service.listarPartidosDaColigacao(idColigacao);
    }
}
