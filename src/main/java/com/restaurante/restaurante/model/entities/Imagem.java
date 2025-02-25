package com.restaurante.restaurante.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "imagem")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imagemId;

    private String nome;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] dados;

    public Imagem() {}

    public Long getImagemId() {
        return imagemId;
    }

    public void setImagemId(Long imagemId) {
        this.imagemId = imagemId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getDados() {
        return dados;
    }

    public void setDados(byte[] dados) {
        this.dados = dados;
    }
}
