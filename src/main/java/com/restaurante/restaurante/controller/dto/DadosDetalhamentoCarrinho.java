package com.restaurante.restaurante.controller.dto;

import com.restaurante.restaurante.model.entities.Carrinho;
import com.restaurante.restaurante.model.entities.CarrinhoItem;

import java.util.List;

public record DadosDetalhamentoCarrinho(Long carrinhoId,
                                        List<CarrinhoItem> itens,
                                        boolean finalizado,
                                        long clienteId,
                                        double valorTotal) {
    public DadosDetalhamentoCarrinho(Carrinho carrinho) {
        this(carrinho.getCarrinhoId(), carrinho.getItens(), carrinho.isFinalizado(), carrinho.getCliente().getClienteId(), carrinho.getValorTotal());
    }
}
