package com.dadoLivre.api.repository;

import com.dadoLivre.api.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    // RF04 - Busca por nome
    List<Candidato> findByNomeContainingIgnoreCase(String nome);

    // RF05 - Filtros individuais
    List<Candidato> findByPartidoIgnoreCase(String partido);
    List<Candidato> findByCargoIgnoreCase(String cargo);
    List<Candidato> findByEstadoIgnoreCase(String estado);
    List<Candidato> findByCidadeIgnoreCase(String cidade);

    // RF05 - Filtro combinado opcional
    List<Candidato> findByPartidoAndCargoAndEstadoAndCidade(
        String partido, String cargo, String estado, String cidade
    );
}
