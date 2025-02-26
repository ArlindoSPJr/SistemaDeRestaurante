package com.restaurante.restaurante.controller.dto;

import com.restaurante.restaurante.model.entities.Item;
import com.restaurante.restaurante.model.entities.TipoItem;

public record DadosDetalhamentoItens(Long itemId, TipoItem tipoItem, String nome, String descricao, double valor, String urlImagem, int quantidade) {
    public DadosDetalhamentoItens(Item item){
        this(item.getItemId(),item.getTipoItem(), item.getNome(), item.getDescricao(), item.getValor(), item.getUrlImagem(), item.getQuantidade());
    }
}
