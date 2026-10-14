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
@Table(name = "notificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notificacao {

    @Id
    @Column(name = "nof_id", length = 36)
    private String nofId;

    @Column(name = "nof_titulo", length = 45)
    private String nofTitulo;

    @Column(name = "nof_lido")
    private Boolean nofLido;

    @Column(name = "nof_data", length = 45)
    private String nofData;

    @ManyToOne
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "not_id", referencedColumnName = "not_id")
    private Noticia noticia;
}