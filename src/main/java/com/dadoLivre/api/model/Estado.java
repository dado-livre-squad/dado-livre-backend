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
@Table(name = "Estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @Column(name = "est_id", length = 36)
    private String estId;

    @Column(name = "est_nome", length = 45)
    private String estNome;

    @Column(name = "est_sigla", length = 2)
    private char estSigla;
}