package com.dadoLivre.api.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dadoLivre.api.dto.candidatofoto.CandidatoFotoResponseDTO;
import com.dadoLivre.api.repository.CandidatoFotoRepository;
import org.springframework.http.MediaType;

@Service
public class CandidatoFotoService {
    private final CandidatoFotoRepository fotoRepository;

    CandidatoFotoService(CandidatoFotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    public Optional<CandidatoFotoResponseDTO> fotoCandidato(UUID id) {
        return fotoRepository.fotoCandidato(id)
                .filter(f -> f.getFoto() != null)
                .map(f -> new CandidatoFotoResponseDTO(
                        f.getId(),
                        f.getFoto(),
                        (f.getTipo() != null && f.getTipo().contains("/"))
                                ? f.getTipo()
                                : MediaType.IMAGE_JPEG_VALUE));
    }
}
