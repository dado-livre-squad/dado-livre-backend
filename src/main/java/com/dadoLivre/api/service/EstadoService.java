package com.dadoLivre.api.service;

import com.dadoLivre.api.dto.estado.EstadoResponseDTO;
import com.dadoLivre.api.model.entities.Estado;
import com.dadoLivre.api.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoService {

    @Autowired
    public EstadoRepository repository;

    public List<EstadoResponseDTO> listarEstados() {
        return repository.listarEstados()
                .stream()
                .map(est -> new EstadoResponseDTO(est.getId(), est.getNome(), est.getSigla()))
                .toList();
    }
}
