package com.dadoLivre.api.controller;

import com.dadoLivre.api.dto.candidato.CandidatoResponseDTO;
import com.dadoLivre.api.service.CandidatoFotoService;
import com.dadoLivre.api.service.CandidatoService;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.http.MediaType;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/candidato")
public class CandidatoController {

    public final CandidatoService service;

    public final CandidatoFotoService fotoService;

    CandidatoController(CandidatoService service, CandidatoFotoService fotoService) {
        this.service = service;
        this.fotoService = fotoService;
    }

    @GetMapping()
    public List<CandidatoResponseDTO> listarCandidatos() {
        return this.service.listarCandidatos();
    }

    @GetMapping("{id}/foto")
    public ResponseEntity<byte[]> fotoCandidato(@PathVariable("id") UUID id) {
        return fotoService.fotoCandidato(id)
                .map(f -> ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(f.tipo()))
                        .cacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic())
                        .body(f.foto()))
                .orElse(ResponseEntity.notFound().build());
    }
}
