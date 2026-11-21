package com.dadoLivre.api.model.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "usu_tipo", discriminatorType = DiscriminatorType.STRING)
@Data 
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "usu_id", length = 36)
    private UUID id;

    @Column(name = "usu_nome")
    private String nome;

    @Column(name = "usu_sobrenome")
    private String sobrenome;

    @Column(name = "usu_email")
    private String email;

    @Column(name = "usu_senha_hash")
    private String senhaHash;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;
}
