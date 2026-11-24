package com.dadoLivre.api.dto.usuario;

public class NomeUsuarioResponseDTO {
    private String nome;

    public NomeUsuarioResponseDTO() {
    }

    public NomeUsuarioResponseDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
