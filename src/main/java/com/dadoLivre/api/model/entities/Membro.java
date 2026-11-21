package com.dadoLivre.api.model.entities;

import com.dadoLivre.api.model.enums.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("MEMBRO")
@Data 
@EqualsAndHashCode(callSuper = true)
public class Membro extends Usuario {

    @Column(name = "usu_tipo", insertable=false, updatable=false)
    private TipoUsuario tipoUsuario;
}
