package com.techlab.proyecto_final_spring_boot.repository;
import com.techlab.proyecto_final_spring_boot.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
