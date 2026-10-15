package com.dadoLivre.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "est_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "est_nome")
    private String nome;

    @Column(name = "est_sigla")
    private String sigla;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;
}
