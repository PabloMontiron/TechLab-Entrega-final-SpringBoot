package com.techlab.proyecto_final_spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineasP = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario cliente;

    private double montoTotal;

    // Get & Set.
    public Long getIdPedido() { return idPedido; }
    public void setIdPedido(Long idPedido) { this.idPedido = idPedido; }
    public List<LineaPedido> getLineaPedido() { return lineasP; }
    public void setLineaPeido(List<LineaPedido> lineaPedido) { this.lineasP = lineaPedido; }
    public Usuario getCliente() { return cliente; }
    public void setCliente(Usuario cliente) { this.cliente = cliente; }
    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
}
