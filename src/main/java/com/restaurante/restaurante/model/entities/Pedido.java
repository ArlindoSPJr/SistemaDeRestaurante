package com.restaurante.restaurante.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    private double valorTotal;
    private StatusPedido statusPedido;

    @OneToOne
    @JoinTable(
            name = "pedido_item", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Item item;
}
