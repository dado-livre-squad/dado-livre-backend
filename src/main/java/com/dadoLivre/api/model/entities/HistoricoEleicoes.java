package com.dadoLivre.api.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "historicoeleicoes")
@Data
public class HistoricoEleicoes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "his_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "his_ano")
    private Integer ano;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidato candidato;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "sit_id")
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "par_id")
    private Partido partido;
}
