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
@Table(name = "TipoBem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoBem {

    @Id
    @Column(name = "tpb_id", length = 36)
    private String tpbId;

    @Column(name = "tpb_nome", length = 600)
    private String tpbNome;
}