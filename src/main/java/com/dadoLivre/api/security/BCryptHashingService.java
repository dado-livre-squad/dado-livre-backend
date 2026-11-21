package com.dadoLivre.api.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptHashingService implements HashingService {

    private final BCryptPasswordEncoder encoder;

    public BCryptHashingService(@Value("${app.security.bcrypt.strength:12}") int strength) {
        this.encoder = new BCryptPasswordEncoder(strength);
    }

    @Override
    public String hash(String rawValue) {
        return encoder.encode(rawValue);
    }

    @Override
    public boolean compare(String rawValue, String hashedValue) {
        return encoder.matches(rawValue, hashedValue);
    }
}