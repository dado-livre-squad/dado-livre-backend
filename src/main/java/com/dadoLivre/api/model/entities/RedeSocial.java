package com.dadoLivre.api.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "redesocial")
public class RedeSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "red_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "red_endereco")
    private String enderecoRedeSocial;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;

    @ManyToOne
    @JoinColumn(name = "can_id")
    @JsonIgnore
    private Candidato candidato;
}
