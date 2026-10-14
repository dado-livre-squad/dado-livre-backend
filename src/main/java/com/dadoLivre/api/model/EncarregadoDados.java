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
@Table(name = "EncarregadoDados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EncarregadoDados {

    @Id
    @Column(name = "enc_id", length = 36)
    private String encId;

    @Column(name = "enc_nome", length = 45)
    private String encNome;
}