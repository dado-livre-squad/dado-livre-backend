package com.dadoLivre.api.service;

import com.dadoLivre.api.dto.candidato.CandidatoResponseDTO;
import com.dadoLivre.api.dto.cargo.CargoResponseDTO;
import com.dadoLivre.api.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import com.dadoLivre.api.dto.partido.PartidoResponseDTO;

import java.util.List;

@Service
public class CandidatoService {

    public final CandidatoRepository repository;

    CandidatoService(CandidatoRepository repository) {
        this.repository = repository;
    }

    public List<CandidatoResponseDTO> listarCandidatos() {
        return repository.listarCandidatos()
        .stream()
        .map(candidato -> {
            PartidoResponseDTO partidoDto = new PartidoResponseDTO(
                    candidato.getPartidoid(),
                    candidato.getNomepartido(),
                    candidato.getSiglapartido(),
                    candidato.getNumeropartido()
            );

            CargoResponseDTO cargoDto = new CargoResponseDTO(
                    candidato.getCargoid(),
                    candidato.getNomeCargo()
            );

            return new CandidatoResponseDTO(
                    candidato.getIdcandidato(),
                    candidato.getNomesocial(),
                    cargoDto,
                    partidoDto
            );
        })
        .toList();
    }
}
