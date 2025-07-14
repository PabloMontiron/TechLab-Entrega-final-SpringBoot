package com.techlab.proyecto_final_spring_boot.controller;
import com.techlab.proyecto_final_spring_boot.entity.Producto;
import com.techlab.proyecto_final_spring_boot.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    // Const.
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Met.
    @GetMapping("/buscarproducto/{id}")
    public ResponseEntity<?> buscarProducto(@PathVariable Long id) {
        Producto prod = productoService.buscarProductoPorId(id);

        if (prod != null) {
            productoService.buscarProductoPorId(id);
            return ResponseEntity.ok(prod);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }

    @GetMapping("/listarproductos")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping("/crearproducto")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @PutMapping("/actualizarproducto/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto existeProd = productoService.buscarProductoPorId(id);

        if (existeProd != null) {
            productoService.actualizarProducto(id,producto);
            return ResponseEntity.ok("Producto Actualizdo");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }

    @DeleteMapping("/eliminarproducto/{id}")
    public ResponseEntity<String> eliminarProductoPorId(@PathVariable Long id) {
        boolean eliminado = productoService.eliminarProductoPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Producto eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }
}
