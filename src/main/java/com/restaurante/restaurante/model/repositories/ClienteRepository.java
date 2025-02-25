package com.restaurante.restaurante.model.repositories;

import com.restaurante.restaurante.model.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByClienteId(Long clienteId);

    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
}
