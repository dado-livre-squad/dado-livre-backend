package com.dadoLivre.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dadoLivre.api.model.entities.Usuario;
import com.dadoLivre.api.model.enums.TipoUsuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    @Modifying
    @Query(
        value = "CALL cadastrarUsuario(:nome, :sobrenome, :email, :hash, :tipo)", 
        nativeQuery = true
    )
    void cadastrarUsuario(
            @Param("nome") String nome,
            @Param("sobrenome") String sobrenome,
            @Param("email") String email,
            @Param("hash") String senhaHash,
            @Param("tipo") String tipoUsuario
        );
}
