package com.dadoLivre.api.model.entities;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "candidatofoto")
@Data
public class CandidatoFoto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cft_id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "cft_dados")
    @ToString.Exclude
    private byte[] dados;

    @Column(name = "cft_tipo")
    private String tipo;

    @OneToOne 
    @JoinColumn(name = "can_id")
    @JsonIgnore 
    private Candidato candidato;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;
}
