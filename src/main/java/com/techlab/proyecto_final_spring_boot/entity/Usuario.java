package com.techlab.proyecto_final_spring_boot.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idUsuario;
    private String nombreUsuario;
    private String nomYApe;
    private int dni;

    // Get & Set
    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }
    public String getNomYApe() { return nomYApe; }
    public void setNomYApe(String nomYApe) { this.nomYApe = nomYApe; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
}
