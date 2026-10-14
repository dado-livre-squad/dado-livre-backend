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
@Table(name = "HistoricoEleitoral")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoEleitoral {

    @Id
    @Column(name = "his_id")
    private Integer hisId;

    @Column(name = "his_ano")
    private Integer hisAno;

    @ManyToOne
    @JoinColumn(name = "can_id", referencedColumnName = "can_id")
    private Candidato candidato;

    @ManyToOne
    @JoinColumn(name = "sit_id", referencedColumnName = "sit_id")
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "par_id", referencedColumnName = "par_id")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Cargo cargo;
}