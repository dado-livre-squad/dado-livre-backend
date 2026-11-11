package com.dadoLivre.api.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "par_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "par_nome")
    private String nome;

    @Column(name = "par_sigla")
    private String sigla;

    @Column(name = "par_numero")
    private Integer numero;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;

    @ManyToOne
    @JoinColumn(name = "enc_id", referencedColumnName = "enc_id")
    private EncarregadoDados encarregadoDados;

    @ManyToOne
    @JoinColumn(name = "col_id")
    private Coligacao coligacao;

    @OneToOne
    @JoinColumn(name = "sit_id")
    private Situacao situacao;
}
