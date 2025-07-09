package com.techlab.proyecto_final_spring_boot.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonProperty("id_pedido")
    private Long idPedido;
    private List<Producto> lProductos = new ArrayList<>();
    private Usuario cliente;
    private double montoTotal;

    // Get & Set.
    public Long getIdPedido() { return idPedido; }
    public List<Producto> getlProductos() { return lProductos; }
    public void setIdPedido(Long idPedido) { this.idPedido = idPedido; }
    public Usuario getCliente() { return cliente; }
    public void setCliente(Usuario cliente) { this.cliente = cliente; }
    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
}
