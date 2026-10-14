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
@Table(name = "Bens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bens {

    @Id
    @Column(name = "ben_id", length = 36)
    private String benId;

    @Column(name = "ben_nome", length = 45)
    private String benNome;

    @Column(name = "ben_valor")
    private Float benValor;

    @ManyToOne
    @JoinColumn(name = "tpb_id", referencedColumnName = "tpb_id")
    private TipoBem tipoBem;

    @ManyToOne
    @JoinColumn(name = "can_id", referencedColumnName = "can_id")
    private Candidato candidato;
}