package com.exemplo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cargo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "car_nome", length = 45)
    private String carNome;

    @Column(name = "car_tempo_duracao")
    private Integer carTempoDuracao;
}