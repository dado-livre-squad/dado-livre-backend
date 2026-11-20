package com.dadoLivre.api.dto.candidato;

import java.util.List;
import java.util.UUID;

import com.dadoLivre.api.dto.redesocial.RedeSocialResponseDTO;

public record CandidateDetailsResponseDTO(
    UUID idCandidato,
    String nomeSocial,
    String sobre,
    Integer idade,
    String estado,
    String partido,
    Integer numeroPartido,
    String nomeCargo,
    String tipoCargo,

    List<RedeSocialResponseDTO> redesSociais
) {}
