package com.dadoLivre.api.dto.candidato;

import java.util.UUID;

import com.dadoLivre.api.dto.cargo.CargoResponseDTO;
import com.dadoLivre.api.dto.partido.PartidoResponseDTO;

public record CandidatoResponseDTO(
    UUID idCandidato, 
    String nomeSocial, 
    String foto, 
    CargoResponseDTO cargo,
    PartidoResponseDTO partido
) { }
