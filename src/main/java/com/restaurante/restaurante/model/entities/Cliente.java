package com.restaurante.restaurante.model.entities;

import com.restaurante.restaurante.controller.dto.DadosCadastroCliente;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    private String nome;
    private String cpf;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "cliente_pedido", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id")
    )
    private List<Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "carrinho_carrinho_id")
    private Carrinho carrinho;

    private Boolean ativo;

    public Cliente() {}

    public Cliente(DadosCadastroCliente dto){
        this.ativo = true;
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.password = dto.password();
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
