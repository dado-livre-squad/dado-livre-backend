package com.dadoLivre.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dadoLivre.api.dto.redesocial.RedeSocialProjection;
import com.dadoLivre.api.model.entities.RedeSocial;

public interface RedeSocialRepository extends JpaRepository<RedeSocial, UUID> {

    @Query(
        value = "SELECT * FROM redeSocialCandidato(:idCandidato)",
        nativeQuery = true
    )
    List<RedeSocialProjection> redesSociaisCandidato(@Param("idCandidato") UUID id);
}
