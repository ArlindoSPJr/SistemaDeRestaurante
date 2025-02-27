package com.restaurante.restaurante.model.repositories;

import com.restaurante.restaurante.model.entities.Cliente;
import com.restaurante.restaurante.model.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findPedidoByCliente(Cliente cliente);

    List<Pedido> findPedidoByClienteCpf(String cpf);
}
