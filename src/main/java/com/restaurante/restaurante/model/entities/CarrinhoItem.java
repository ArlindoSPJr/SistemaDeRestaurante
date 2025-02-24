package com.restaurante.restaurante.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "carrinhoItem")
public class CarrinhoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carrinhoItemId;

    @ManyToOne
    private Item item;

    private int quantidade;

    public CarrinhoItem() {}

    public CarrinhoItem(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public Long getCarrinhoItemId() {
        return carrinhoItemId;
    }

    public void setCarrinhoItemId(Long carrinhoItemId) {
        this.carrinhoItemId = carrinhoItemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
