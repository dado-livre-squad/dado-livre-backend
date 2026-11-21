package com.dadoLivre.api.security;

public interface HashingService {
    String hash(String rawValue);
    boolean compare(String rawValue, String hashedValue);
}
