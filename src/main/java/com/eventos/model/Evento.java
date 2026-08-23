package com.eventos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "eventos")
public class Evento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false)
    private String nombre;
    
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;
    
    @NotBlank(message = "La fecha no puede estar vacía")
    private String fecha;
    
    @NotBlank(message = "La ubicación no puede estar vacía")
    private String ubicacion;
    
    @Min(value = 1, message = "La capacidad debe ser al menos 1")
    @Max(value = 100000, message = "La capacidad no puede superar 100000")
    private int capacidad;
    
    // Constructor sin parámetros (JPA lo necesita obligatoriamente)
    public Evento() {
    }
    
    // Constructor con parámetros (sin el id, porque lo genera la BD)
    public Evento(String nombre, String descripcion, String fecha, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
