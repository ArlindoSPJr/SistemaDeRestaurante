package com.restaurante.restaurante.controller.dto;

import com.restaurante.restaurante.model.entities.Cliente;

public record DadosDetalhamentoCliente(Long id,String nome, String cpf, String password) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getClienteId(), cliente.getNome(), cliente.getCpf(), cliente.getPassword());
    }

}
