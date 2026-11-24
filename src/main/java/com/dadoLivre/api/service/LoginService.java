package com.dadoLivre.api.service;

import org.springframework.stereotype.Service;

import com.dadoLivre.api.dto.login.LoginRequestDTO;
import com.dadoLivre.api.dto.login.LoginResponseDTO;
import com.dadoLivre.api.exception.UnathourizedException;
import com.dadoLivre.api.security.HashingService;
import com.dadoLivre.api.security.JwtService;

@Service 
public class LoginService {
    
    private final UsuarioService usuarioService;
    private final HashingService hashingService;
    private final JwtService jwtService;

    public LoginService(
        UsuarioService usuarioService,
        HashingService hashingService,
        JwtService jwtService
    ) {
        this.usuarioService = usuarioService;
        this.hashingService = hashingService;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {
        var usuario = usuarioService.usuarioPorEmail(dto.getEmail());
        var nomeUsuario = usuarioService.nomeUsuario(dto.getEmail());
        var isValidPassword = hashingService.compare(dto.getSenha(), usuario.getSenha());

        if (!isValidPassword) throw new UnathourizedException("Usuário ou senha inválidos.");

        return new LoginResponseDTO(jwtService.gerar(usuario.getEmail(), nomeUsuario.getNome()));
    }  
}
