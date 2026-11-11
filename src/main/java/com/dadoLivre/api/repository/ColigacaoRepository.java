package com.dadoLivre.api.repository;

import com.dadoLivre.api.dto.partido.PartidoProjection;
import com.dadoLivre.api.model.entities.Coligacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ColigacaoRepository extends JpaRepository<Coligacao, UUID> {

    @Query(value = "SELECT * FROM partidosDaColigacao(:idColigacao)", nativeQuery = true)
    List<PartidoProjection> listarPartidosDaColigacao(@Param("idColigacao") UUID idColigacao);
}
