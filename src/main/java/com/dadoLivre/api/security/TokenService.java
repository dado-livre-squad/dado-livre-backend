package com.dadoLivre.api.security;

import java.util.Optional;

public interface TokenService {
    String gerar(String subject, String nome);
    Optional<String> validar(String token);
}