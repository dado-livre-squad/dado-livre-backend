package com.dadoLivre.api.security;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service 
public class JwtService implements TokenService {

    private static final String ISSUER = "api";

    private final SecretKey key;
    private final Duration expiracao;

    public JwtService(JwtProperties properties) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(properties.secret()));
        this.expiracao = Duration.ofMinutes(properties.expirationMinutes());
    }

    @Override
    public String gerar(String subject) {
        Instant agora = Instant.now();
        
        return Jwts.builder()
                .issuer(ISSUER)
                .subject(subject)
                .issuedAt(Date.from(agora))
                .expiration(Date.from(agora.plus(expiracao)))
                .signWith(key) // HS256 para chave de 256 bits
                .compact();
    }

    @Override
    public Optional<String> validar(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validar'");
    }
    
}
