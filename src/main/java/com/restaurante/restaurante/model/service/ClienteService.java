package com.restaurante.restaurante.model.service;

import com.restaurante.restaurante.model.entities.Cliente;
import com.restaurante.restaurante.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).get();
    }

    public void save(Cliente cliente) {
        String senhaCriptografada = passwordEncoder.encode(cliente.getPassword());
        cliente.setPassword(senhaCriptografada);
        clienteRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

}
