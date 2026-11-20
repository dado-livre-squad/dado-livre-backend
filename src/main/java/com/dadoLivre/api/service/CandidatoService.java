package com.dadoLivre.api.service;

import com.dadoLivre.api.dto.candidato.CandidateDetailsResponseDTO;
import com.dadoLivre.api.dto.candidato.CandidatoResponseDTO;
import com.dadoLivre.api.dto.cargo.CargoResponseDTO;
import com.dadoLivre.api.repository.CandidatoRepository;
import com.dadoLivre.api.repository.RedeSocialRepository;

import org.springframework.stereotype.Service;

import com.dadoLivre.api.dto.partido.PartidoResponseDTO;
import com.dadoLivre.api.dto.redesocial.RedeSocialProjection;
import com.dadoLivre.api.dto.redesocial.RedeSocialResponseDTO;

import java.util.List;
import java.util.UUID;

@Service
public class CandidatoService {

    public final CandidatoRepository repository;

    public final RedeSocialRepository redeSocialRepository;

    CandidatoService(CandidatoRepository repository, RedeSocialRepository redeSocialRepository) {
        this.repository = repository;
        this.redeSocialRepository = redeSocialRepository;
    }

    public List<CandidatoResponseDTO> listarCandidatos() {
        return repository.listarCandidatos()
                .stream()
                .map(candidato -> {
                    PartidoResponseDTO partidoDto = new PartidoResponseDTO(
                            candidato.getPartidoid(),
                            candidato.getNomepartido(),
                            candidato.getSiglapartido(),
                            candidato.getNumeropartido());

                    CargoResponseDTO cargoDto = new CargoResponseDTO(
                            candidato.getCargoid(),
                            candidato.getNomeCargo());

                    return new CandidatoResponseDTO(
                            candidato.getIdcandidato(),
                            candidato.getNomesocial(),
                            cargoDto,
                            partidoDto);
                })
                .toList();
    }

    public CandidateDetailsResponseDTO detalhesCandidato(UUID id) {
        var candidato = repository.detalhesCandidato(id);
        List<RedeSocialProjection> redesSociais = redeSocialRepository.redesSociaisCandidato(id);

        List<RedeSocialResponseDTO> redesDto = redesSociais.stream().map(redeSocial -> {
            RedeSocialResponseDTO rede = new RedeSocialResponseDTO(
                redeSocial.getIdrede(), 
                redeSocial.getEndereco(),
                redeSocial.getNome(),
                redeSocial.getUsuario()
            );

            return rede;
        }).toList();

        return new CandidateDetailsResponseDTO(
                candidato.getId(),
                candidato.getNomesocial(),
                candidato.getSobre(),
                candidato.getIdade(),
                candidato.getEstado(),
                candidato.getPartido(),
                candidato.getNumeropartido(),
                candidato.getcargo(),
                candidato.getTipoCargo(),
                redesDto
            );
    }
}
