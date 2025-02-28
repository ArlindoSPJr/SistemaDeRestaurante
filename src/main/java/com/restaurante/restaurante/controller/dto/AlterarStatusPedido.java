package com.restaurante.restaurante.controller.dto;

import com.restaurante.restaurante.model.entities.Pedido;
import com.restaurante.restaurante.model.entities.StatusPedido;

public record AlterarStatusPedido(Long pedidoId, StatusPedido statusPedido) {
    public AlterarStatusPedido(Pedido pedido) {
        this(pedido.getPedidoId(),pedido.getStatusPedido());
    }
}
