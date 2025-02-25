package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.controller.dto.DadosCadastroCliente;
import com.restaurante.restaurante.controller.dto.DadosDetalhamentoCliente;
import com.restaurante.restaurante.model.entities.Cliente;
import com.restaurante.restaurante.model.repositories.ClienteRepository;
import com.restaurante.restaurante.model.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository) {
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCliente> cadastrarCliente(@RequestBody DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
        var novoCliente = new Cliente(dados);
        clienteService.save(novoCliente);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(novoCliente.getClienteId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(novoCliente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoCliente>> getClientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
       var page = clienteRepository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoCliente::new);
       return ResponseEntity.ok(page);
    }
}
