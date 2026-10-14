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
@Table(name = "Candidato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {

    @Id
    @Column(name = "can_id", length = 36)
    private String canId;

    @Column(name = "can_nome", length = 200)
    private String canNome;

    @Column(name = "can_sobrenome", length = 200)
    private String canSobrenome;

    @Column(name = "can_nomesocial", length = 100)
    private String canNomeSocial;

    @Column(name = "can_foto", length = 200)
    private String canFoto;

    @Temporal(TemporalType.DATE)
    @Column(name = "can_datanascimento")
    private Date canDataNascimento;

    @Column(name = "can_cpf", length = 9)
    private String canCpf;

    @Column(name = "can_cnpj", length = 45)
    private String canCnpj;

    @Column(name = "can_grauinstrucao", length = 20)
    private String canGrauInstrucao;

    @Column(name = "can_formacao", length = 100)
    private String canFormacao;

    @Column(name = "can_cor", length = 50)
    private String canCor;

    @Column(name = "can_etinia", length = 45)
    private String canEtinia;

    @Column(name = "can_ocupacao", length = 45)
    private String canOcupacao;

    @Column(name = "can_nacionalidade", length = 50)
    private String canNacionalidade;

    @Column(name = "can_id_vice", length = 45)
    private String canIdVice;

    @Column(name = "can_certidao", length = 45)
    private String canCertidao;

    @Column(name = "can_consulta", length = 45)
    private String canConsulta;

    @Column(name = "can_ativo")
    private Boolean canAtivo;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "sit_id", referencedColumnName = "sit_id")
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "par_id", referencedColumnName = "par_id")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "enc_id", referencedColumnName = "enc_id")
    private EncarregadoDados encarregadoDados;

    @ManyToOne
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    private Estado estado;
}