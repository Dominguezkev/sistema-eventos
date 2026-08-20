package com.eventos.model;

public class Evento {
    
    // Atributos (propiedades)
    private int id;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String ubicacion;
    private int capacidad;
    
    // Constructor sin parámetros
    public Evento() {
    }
    
    // Constructor con parámetros
    public Evento(int id, String nombre, String descripcion, String fecha, String ubicacion, int capacidad) {
        this.id = id;
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
    
    // toString() para ver el objeto como String
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
