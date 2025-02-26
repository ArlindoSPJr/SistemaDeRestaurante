package com.restaurante.restaurante.model.entities;

import com.restaurante.restaurante.controller.dto.DadosCadastroItens;
import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;
    private String nome;
    private String descricao;
    private double valor;
    private int quantidade;
    private String urlImagem;

    public Item() {}

    public Item(DadosCadastroItens dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.tipoItem = dados.tipoItem();
        this.quantidade = dados.quantidade();
        this.urlImagem = dados.urlImagem();
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
