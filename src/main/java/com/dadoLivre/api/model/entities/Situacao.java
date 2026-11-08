package com.dadoLivre.api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Situacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Situacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sit_id", length = 36)
    private UUID id;

    @Column(name = "sit_tipo", length = 45)
    private String tipo;

    @Column(name = "sit_descricao", length = 1000)
    private String descricao;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;
}