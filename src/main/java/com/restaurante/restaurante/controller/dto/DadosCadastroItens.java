package com.restaurante.restaurante.controller.dto;

import com.restaurante.restaurante.model.entities.TipoItem;

public record DadosCadastroItens(TipoItem tipoItem,
                                 String nome,
                                 String descricao,
                                 double valor,
                                 int quantidade,
                                 String urlImagem) {
}
