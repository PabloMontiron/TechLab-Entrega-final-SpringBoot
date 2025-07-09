package com.techlab.proyecto_final_spring_boot.service;
import com.techlab.proyecto_final_spring_boot.entity.Producto;
import com.techlab.proyecto_final_spring_boot.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService implements iProductoService {

    private final ProductoRepository productoRepository;

    // Const.
    public ProductoService(ProductoRepository prodructoRepository) {
        this.productoRepository = prodructoRepository;
    }

    // Met.
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto buscarProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        Producto p = buscarProductoPorId(id);
        if(p != null) {
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());
            p.setStock(producto.getStock());
            p.setCategoria(producto.getCategoria());

            return productoRepository.save(p);
        }
        return null;
    }

    public boolean eliminarProductoPorId(Long id) {
        if(productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
