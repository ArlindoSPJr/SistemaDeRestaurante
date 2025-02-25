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
}
