package com.restaurante.restaurante.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String nome;
    private String cpf;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "cliente_pedido", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id")
    )
    private List<Pedido> pedidos;
}
