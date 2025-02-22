package com.restaurante.restaurante.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrinho")
public class Carrinho {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carrinhoId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CarrinhoItem> itens;

    private boolean finalizado;

    public Carrinho() {}

    public Long getCarrinhoId() {
        return carrinhoId;
    }

    public void setCarrinhoId(Long carrinhoId) {
        this.carrinhoId = carrinhoId;
    }

    public List<CarrinhoItem> getItens() {
        return itens;
    }

    public void setItens(List<CarrinhoItem> itens) {
        this.itens = itens;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
