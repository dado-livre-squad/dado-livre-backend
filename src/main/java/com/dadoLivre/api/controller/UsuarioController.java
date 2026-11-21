package com.dadoLivre.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dadoLivre.api.dto.usuario.UsuarioRequestDTO;
import com.dadoLivre.api.dto.usuario.UsuarioResponseDTO;
import com.dadoLivre.api.service.UsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(
            @RequestBody UsuarioRequestDTO dto
        ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.cadastrarUsuario(dto));
    }
}
