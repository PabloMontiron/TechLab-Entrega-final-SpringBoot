package com.techlab.proyecto_final_spring_boot.service;

import com.techlab.proyecto_final_spring_boot.entity.Producto;

import java.util.List;

public interface iProductoService {
    Producto crearProducto(Producto producto);
    Producto buscarProductoPorId(Long id);
    List<Producto> listarProductos();
    Producto actualizarProducto(Long id, Producto producto);
    boolean eliminarProductoPorId(Long id);
}
