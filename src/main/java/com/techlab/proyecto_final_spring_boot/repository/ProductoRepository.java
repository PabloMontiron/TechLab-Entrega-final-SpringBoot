package com.techlab.proyecto_final_spring_boot.repository;

import com.techlab.proyecto_final_spring_boot.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> { }
