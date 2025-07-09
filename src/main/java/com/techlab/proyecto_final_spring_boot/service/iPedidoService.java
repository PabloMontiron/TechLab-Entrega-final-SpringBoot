package com.techlab.proyecto_final_spring_boot.service;

import com.techlab.proyecto_final_spring_boot.entity.Pedido;
import com.techlab.proyecto_final_spring_boot.entity.Producto;
import com.techlab.proyecto_final_spring_boot.entity.Usuario;

import java.util.List;

public interface iPedidoService {
    Pedido crearPedido(Usuario cliente);
    Pedido buscarPedidoPorId(Long idPedido);
    Pedido agregarProductoAlPedido(Long idPedido, Producto producto);
    List<Pedido> listarPedidos();
    boolean eliminarPedidoPorId(Long idPedido);
}
