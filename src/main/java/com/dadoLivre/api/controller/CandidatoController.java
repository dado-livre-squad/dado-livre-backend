package com.dadoLivre.api.controller;

import com.dadoLivre.api.dto.candidato.CandidatoResponseDTO;
import com.dadoLivre.api.repository.CandidatoFotoRepository;
import com.dadoLivre.api.service.CandidatoService;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/candidato")
public class CandidatoController {

    @Autowired
    public CandidatoService service;

    @Autowired
    public CandidatoFotoRepository fotoRepository;

    @GetMapping()
    public List<CandidatoResponseDTO> listarCandidatos() {
        return this.service.listarCandidatos();
    }

    @GetMapping("{id}/foto")
    public ResponseEntity<byte[]> fotoCandidato(@PathVariable("id") UUID id) {
        return fotoRepository.fotoCandidato(id)
                .map(foto -> {
                    String tipo = foto.getTipo();
                    MediaType mediaType = (tipo != null && tipo.contains("/"))
                            ? MediaType.parseMediaType(tipo)
                            : MediaType.IMAGE_JPEG;

                    return ResponseEntity.ok()
                            .contentType(mediaType)
                            .cacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic())
                            .body(foto.getFoto());
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
