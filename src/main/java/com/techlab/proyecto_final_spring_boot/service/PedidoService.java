package com.techlab.proyecto_final_spring_boot.service;
import com.techlab.proyecto_final_spring_boot.entity.Pedido;
import com.techlab.proyecto_final_spring_boot.entity.Producto;
import com.techlab.proyecto_final_spring_boot.entity.Usuario;
import com.techlab.proyecto_final_spring_boot.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements iPedidoService {

    public final PedidoRepository pedidoRepository;

    //Const.
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Met.
    public Pedido crearPedido(Usuario cliente) {
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setCliente(cliente);
        nuevoPedido.setMontoTotal(0);

        return pedidoRepository.save(nuevoPedido);
    }

    public Pedido buscarPedidoPorId(Long idPedido) {
        return pedidoRepository.findById(idPedido).orElse(null);
    }

    public Pedido agregarProductoAlPedido(Long idPedido, Producto producto) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pedido != null) {
            pedido.getlProductos().add(producto);
            double totalAcumulado = pedido.getMontoTotal() + producto.getPrecio();
            pedido.setMontoTotal(totalAcumulado);

            return pedidoRepository.save(pedido);
        } else {
            return null;
        }
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public boolean eliminarPedidoPorId(Long idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pedido != null) {
            pedidoRepository.deleteById(idPedido);
            return true;
        } else {
            return false;
        }
    }

}
