package com.dadoLivre.api.service;

import com.dadoLivre.api.dto.partido.PartidoResponseDTO;
import com.dadoLivre.api.exception.ResourceNotFoundException;
import com.dadoLivre.api.model.entities.Coligacao;
import com.dadoLivre.api.repository.ColigacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ColigacaoService {

    @Autowired
    public ColigacaoRepository repository;

    public List<Coligacao> findAll() {
        return this.repository.findAll();
    }

    public Coligacao findOne(UUID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coligação não encontrada."));
    }

    public List<PartidoResponseDTO> listarPartidosDaColigacao(UUID idColigacao) {
        this.findOne(idColigacao);

        return this.repository.listarPartidosDaColigacao(idColigacao)
                .stream()
                .map(partido -> new PartidoResponseDTO(partido.getId(),
                        partido.getNome(), partido.getSigla(), partido.getNumero()))
                .toList();
    }
}
