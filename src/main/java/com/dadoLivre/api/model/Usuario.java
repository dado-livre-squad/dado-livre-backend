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
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @Column(name = "usu_id", length = 36)
    private String usuId;

    @Column(name = "usu_nome", length = 255)
    private String usuNome;

    @Column(name = "usu_email", length = 200)
    private String usuEmail;

    @Column(name = "usu_senhahash", length = 200)
    private String usuSenhaHash;
}