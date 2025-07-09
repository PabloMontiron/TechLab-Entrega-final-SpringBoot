package com.techlab.proyecto_final_spring_boot.service;

import com.techlab.proyecto_final_spring_boot.entity.Usuario;

import java.util.List;

public interface iUsuarioService {
    Usuario crearUsuario(Usuario nuevoUsuario);
    Usuario buscarUsuarioPorId(Long id);
    List<Usuario> listarUsuarios();
    boolean eliminarUsuarioPorId(Long id);
}
