package com.techlab.proyecto_final_spring_boot.service;
import com.techlab.proyecto_final_spring_boot.entity.LineaPedido;
import com.techlab.proyecto_final_spring_boot.entity.Pedido;
import com.techlab.proyecto_final_spring_boot.entity.Producto;
import com.techlab.proyecto_final_spring_boot.entity.Usuario;
import com.techlab.proyecto_final_spring_boot.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements iPedidoService {

    public final PedidoRepository pedidoRepository;
    public final ProductoService productoService;
    //Const.
    public PedidoService(PedidoRepository pedidoRepository, ProductoService productoService) {
        this.pedidoRepository = pedidoRepository;
        this.productoService = productoService;
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

    public Pedido agregarProductoAlPedido(Long idPedido, Long idProducto, int cant) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        Producto producto = productoService.buscarProductoPorId(idProducto);

        if (pedido != null && producto != null) {
            LineaPedido lineaP = new LineaPedido();
            lineaP.setProducto(producto);
            lineaP.setCantidad(cant);
            lineaP.setPedido(pedido);

            pedido.getLineaPedido().add(lineaP);

            double totalAcumulado = pedido.getMontoTotal() + producto.getPrecio() * cant;

            pedido.setMontoTotal(totalAcumulado);

            return pedidoRepository.save(pedido);
        }

        return null;
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
