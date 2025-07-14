package com.techlab.proyecto_final_spring_boot.controller;
import com.techlab.proyecto_final_spring_boot.dto.ProductoDto;
import com.techlab.proyecto_final_spring_boot.entity.Pedido;
import com.techlab.proyecto_final_spring_boot.entity.Producto;
import com.techlab.proyecto_final_spring_boot.entity.Usuario;
import com.techlab.proyecto_final_spring_boot.service.PedidoService;
import com.techlab.proyecto_final_spring_boot.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    public final PedidoService pedidoService;
    public final UsuarioService usuarioService;

    // Const.
    public PedidoController(PedidoService pedidoService, UsuarioService usuarioService) {
        this.pedidoService = pedidoService;
        this.usuarioService = usuarioService;
    }

    // Met.
    @PostMapping("/crearpedido/{id}")
    public ResponseEntity<?> crearPedido(@PathVariable Long id) {
        Usuario cliente = usuarioService.buscarUsuarioPorId(id);

        if (cliente != null) {
            Pedido nuevoPedido = pedidoService.crearPedido(cliente);

            if (nuevoPedido != null) {
                return ResponseEntity.ok(nuevoPedido);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo crear el pedido.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado.");
        }
    }

    @GetMapping("/buscarpedido/{id}")
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);

        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado.");
        }
    }

    @PutMapping("/agregarproducto/{id}")
    public ResponseEntity<String> agregarProductoAlPedido(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
        Pedido pedido = pedidoService.agregarProductoAlPedido(id,productoDto.getIdProducto(),productoDto.getCantidad());

        if (pedido != null) {
            return ResponseEntity.ok("Producto agregado al carrito de compras.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo agregar el producto.");
        }
    }

    @GetMapping("/listarpedidos")
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @DeleteMapping("/eliminarpedido/{id}")
    public ResponseEntity<String> eliminarPedidoPorId(@PathVariable Long id) {
        boolean pedido = pedidoService.eliminarPedidoPorId(id);

        if (pedido) {
            return ResponseEntity.ok("Pedido eliminado.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido no encontrado.");
        }
    }

}
