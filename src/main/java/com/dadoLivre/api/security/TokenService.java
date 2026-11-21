package com.dadoLivre.api.security;

import java.util.Optional;

public interface TokenService {
    String gerar(String subject);
    Optional<String> validar(String token);
}