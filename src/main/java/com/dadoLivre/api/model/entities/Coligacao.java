package com.dadoLivre.api.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Coligacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "col_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "col_nome")
    private String nome;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Partido> partidos;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;
}
