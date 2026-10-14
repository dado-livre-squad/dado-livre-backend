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
@Table(name = "Coligacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coligacao {

    @Id
    @Column(name = "col_id", length = 36)
    private String colId;

    @Column(name = "col_nome", length = 45)
    private String colNome;
}