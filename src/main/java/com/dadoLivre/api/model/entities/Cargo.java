package com.dadoLivre.api.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "car_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "car_nome")
    private String nome;


}
