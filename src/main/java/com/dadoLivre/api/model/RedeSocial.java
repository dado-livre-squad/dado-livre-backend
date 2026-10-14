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
@Table(name = "RedeSocial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RedeSocial {

    @Id
    @Column(name = "sit_id")
    private Integer sitId;

    @Column(name = "red_endereco", length = 45)
    private String redEndereco;

    @Column(name = "red_id", length = 36)
    private String redId;

    @ManyToOne
    @JoinColumn(name = "can_id", referencedColumnName = "can_id")
    private Candidato candidato;
}