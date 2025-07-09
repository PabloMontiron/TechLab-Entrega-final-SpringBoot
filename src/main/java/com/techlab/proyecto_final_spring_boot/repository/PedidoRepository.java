package com.techlab.proyecto_final_spring_boot.repository;

import com.techlab.proyecto_final_spring_boot.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> { }
