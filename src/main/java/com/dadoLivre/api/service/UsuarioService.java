package com.dadoLivre.api.service;

import org.springframework.stereotype.Service;

import com.dadoLivre.api.dto.usuario.UsuarioRequestDTO;
import com.dadoLivre.api.dto.usuario.UsuarioResponseDTO;
import com.dadoLivre.api.repository.UsuarioRepository;
import com.dadoLivre.api.security.HashingService;

import jakarta.transaction.Transactional;

@Service 
public class UsuarioService {
    private final UsuarioRepository repository;
    private final HashingService hashingService;

    public UsuarioService(
        UsuarioRepository repository,
        HashingService hashingService
    ) {
        this.repository = repository;
        this.hashingService = hashingService;
    }

    @Transactional 
    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto) {
        var hashedPassword = this.hashingService.hash(dto.getSenha());
        UsuarioRequestDTO usuario = new UsuarioRequestDTO();

        usuario.setNome(dto.getNome());
        usuario.setSobrenome(dto.getSobrenome());
        usuario.setSenha(hashedPassword);
        usuario.setTipo(dto.getTipo());
        usuario.setEmail(dto.getEmail());

        this.repository.cadastrarUsuario(
            usuario.getNome(),
            usuario.getSobrenome(),
            usuario.getEmail(),
            usuario.getSenha(),
            usuario.getTipo().toString()
        );

        return new UsuarioResponseDTO(
            usuario.getNome(),
            usuario.getSobrenome(),
            usuario.getEmail(),
            usuario.getTipo()
        );
    }
}
