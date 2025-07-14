package com.techlab.proyecto_final_spring_boot.dto;

public class ProductoDto {
    private Long idProducto;
    private int cantidad;

    // Get & Set.

    public Long getIdProducto() { return idProducto; }
    public void setIdProducto(Long idProducto) { this.idProducto = idProducto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
