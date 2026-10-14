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
@Table(name = "Seguindo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seguindo {

    @Id
    @Column(name = "usu_id")
    private Integer usuId;

    @ManyToOne
    @JoinColumn(name = "can_id", referencedColumnName = "can_id")
    private Candidato candidato;
}