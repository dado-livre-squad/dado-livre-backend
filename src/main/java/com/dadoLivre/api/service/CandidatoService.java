package com.dadoLivre.api.service;

import com.dadoLivre.api.dto.candidato.CandidatoReponseProjection;
import com.dadoLivre.api.dto.candidato.CandidatoResponseDTO;
import com.dadoLivre.api.dto.cargo.CargoResponseDTO;
import com.dadoLivre.api.model.entities.Candidato;
import com.dadoLivre.api.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dadoLivre.api.dto.partido.PartidoResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    public CandidatoRepository repository;

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
                    candidato.getFoto(),
                    cargoDto,
                    partidoDto
            );
        })
        .toList();
    }
}
