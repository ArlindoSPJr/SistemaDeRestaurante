package com.restaurante.restaurante.controller.dto;

import com.restaurante.restaurante.model.entities.CarrinhoItem;
import com.restaurante.restaurante.model.entities.Item;
import com.restaurante.restaurante.model.entities.Pedido;
import com.restaurante.restaurante.model.entities.StatusPedido;

import java.util.List;

public record DadosDetalhamentoPedido(Long pedidoId,
                                      StatusPedido statusPedido,
                                      double valorTotal,
                                      Long clienteId,
                                      List<CarrinhoItem> itens) {
    public DadosDetalhamentoPedido(Pedido pedido) {
        this(pedido.getPedidoId(), pedido.getStatusPedido(), pedido.getValorTotal(), pedido.getCliente().getClienteId(), pedido.getCarrinho().getItens());
    }
}
