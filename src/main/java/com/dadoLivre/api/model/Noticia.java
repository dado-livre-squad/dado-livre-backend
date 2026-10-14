package com.exemplo.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Noticia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Noticia {

    @Id
    @Column(name = "not_id", length = 36)
    private String notId;

    @Column(name = "not_titulo", length = 100)
    private String notTitulo;

    @Column(name = "not_autor", length = 255)
    private String notAutor;

    @Temporal(TemporalType.DATE)
    @Column(name = "not_data")
    private Date notData;

    @Column(name = "not_fonte", length = 100)
    private String notFonte;

    @Column(name = "not_url", length = 255)
    private String notUrl;

    @Column(name = "not_descricao", length = 255)
    private String notDescricao;

    @Column(name = "not_urlimagem", length = 255)
    private String notUrlImagem;

    @ManyToOne
    @JoinColumn(name = "can_id", referencedColumnName = "can_id")
    private Candidato candidato;
}