package com.dadoLivre.api.service;

import com.dadoLivre.api.dto.estado.EstadoResponseDTO;
import com.dadoLivre.api.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    public final EstadoRepository repository;

    EstadoService(EstadoRepository repository) {
        this.repository = repository;
    }

    public List<EstadoResponseDTO> listarEstados() {
        return repository.listarEstados()
                .stream()
                .map(est -> new EstadoResponseDTO(est.getId(), est.getNome(), est.getSigla()))
                .toList();
    }
}
