package com.dadoLivre.api.model.entities;

import com.dadoLivre.api.model.enums.Cor;
import com.dadoLivre.api.model.enums.GrauInstrucao;
import com.dadoLivre.api.model.enums.Nacionalidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "candidato")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "can_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "can_nome")
    private String nome;

    @Column(name = "can_sobrenome")
    private String sobrenome;

    @Column(name = "can_nomesocial")
    private String nomeSocial;

    @Column(name = "can_foto")
    private String fotoUrl;

    @Column(name = "can_datanascimento")
    private Date dataNascimento;

    @Column(name = "can_cpf", unique = true, length = 11)
    private String cpf;

    @Column(name = "can_cnpj", unique = true, length = 14)
    private String cnpj;

    @Enumerated(EnumType.STRING)
    @Column(name = "can_grauinstrucao")
    private GrauInstrucao grauInstrucao;

    @Column(name = "can_formacao")
    private String formacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "can_cor")
    private Cor cor;

    @Column(name = "can_ocupacao")
    private String ocupacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "can_nacionalidade")
    private Nacionalidade nacionalidade;

    @OneToOne
    @JoinColumn(name = "can_id_vice")
    private Candidato companheiroChapa;

    @Column(name = "can_certidao")
    private String certidao;

    @Column(name = "can_consulta")
    private String consulta;

    @Column(name = "can_ativo")
    private boolean isAtivo;

    @Column(name = "criadoem")
    private Date criadoEm;

    @Column(name = "atualizadoem")
    private Date atualizadoEm;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "sit_id")
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "par_id")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "enc_id")
    private EncarregadoDados encarregadoDados;

    @ManyToOne
    @JoinColumn(name = "est_id")
    private Estado estado;
}