package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.controller.dto.AlterarStatusPedido;
import com.restaurante.restaurante.model.entities.Pedido;
import com.restaurante.restaurante.model.repositories.PedidoRepository;
import com.restaurante.restaurante.model.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoService pedidoService, PedidoRepository pedidoRepository) {
        this.pedidoService = pedidoService;
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public List<Pedido> getAllPedidos(){
        return pedidoService.findAll();
    }

    @GetMapping("/cpf")
    public List<Pedido> getPedidoByClienteCpf(String cpf){
        return pedidoService.findByClienteCpf(cpf);
    }

    @PutMapping
    public ResponseEntity<AlterarStatusPedido> alterarStatusPedido(@RequestBody AlterarStatusPedido dados){
        Pedido pedidoEncontrado = pedidoRepository.findByPedidoId(dados.pedidoId());
        if (pedidoEncontrado == null){
            return ResponseEntity.notFound().build();
        }
        pedidoService.alterarStatus(pedidoEncontrado, dados.statusPedido());

        return ResponseEntity.ok().body(new AlterarStatusPedido(pedidoEncontrado));
    }
}
