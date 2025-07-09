package com.techlab.proyecto_final_spring_boot.controller;
import com.techlab.proyecto_final_spring_boot.entity.Usuario;
import com.techlab.proyecto_final_spring_boot.service.ProductoService;
import com.techlab.proyecto_final_spring_boot.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    public final UsuarioService usuarioService;

    // Const.
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Met.
    @PostMapping("/crearusuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/listarusuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/buscarusuario/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }
    }

    @DeleteMapping("/eliminarusuario/{id}")
    public ResponseEntity<String> eliminarUsuarioPorId(@PathVariable Long id) {
        boolean usuario = usuarioService.eliminarUsuarioPorId(id);

        if (usuario) {
            return ResponseEntity.ok("Usuario eliminado.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el usuario.");
        }
    }
}
