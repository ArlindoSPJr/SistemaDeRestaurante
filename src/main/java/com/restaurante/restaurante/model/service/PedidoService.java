package com.restaurante.restaurante.model.service;

import com.restaurante.restaurante.model.entities.Cliente;
import com.restaurante.restaurante.model.entities.Pedido;
import com.restaurante.restaurante.model.entities.StatusPedido;
import com.restaurante.restaurante.model.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> findByClienteCpf(String cpf) {
        return pedidoRepository.findPedidoByClienteCpf(cpf);
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).get();
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido alterarStatus(Pedido pedido, StatusPedido statusPedido) {
        pedido.setStatusPedido(statusPedido);
        return pedidoRepository.save(pedido);
    }
}
