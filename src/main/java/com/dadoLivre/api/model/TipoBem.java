package com.dadoLivre.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tipobem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoBem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tpb_id", length = 36)
    private UUID id;

    @Column(name = "tpb_nome", length = 600)
    private String nome;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;
}

