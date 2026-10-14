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
@Table(name = "Situacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Situacao {

    @Id
    @Column(name = "sit_id", length = 36)
    private String sitId;

    @Column(name = "sit_tipo", length = 45)
    private String sitTipo;

    @Column(name = "sit_descricao", length = 1000)
    private String sitDescricao;
}