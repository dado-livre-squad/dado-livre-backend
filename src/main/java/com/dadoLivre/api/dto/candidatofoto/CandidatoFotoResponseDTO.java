package com.dadoLivre.api.dto.candidatofoto;

import java.util.UUID;

public record CandidatoFotoResponseDTO(UUID id, byte[] foto, String tipo) { 
    
}
