package com.exemplo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Partido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Partido {

    @Id
    @Column(name = "par_id", length = 36)
    private String parId;

    @Column(name = "par_nome", length = 45)
    private String parNome;

    @Column(name = "par_sigla", length = 5)
    private String parSigla;

    @Column(name = "par_numero")
    private Integer parNumero;

    @ManyToOne
    @JoinColumn(name = "col_id", referencedColumnName = "col_id")
    private Coligacao coligacao;

    @ManyToOne
    @JoinColumn(name = "sit_id", referencedColumnName = "sit_id")
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "enc_id", referencedColumnName = "enc_id")
    private EncarregadoDados encarregadoDados;
}