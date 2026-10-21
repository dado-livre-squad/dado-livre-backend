package com.dadoLivre.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "encarregadodados")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EncarregadoDados {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "enc_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "enc_nome")
    private String nome;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;
}
