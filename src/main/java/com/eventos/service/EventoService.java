package com.eventos.service;

import com.eventos.model.Evento;
import java.util.ArrayList;
import java.util.List;

public class EventoService {
    
    // Lista para almacenar eventos en memoria
    private List<Evento> eventos = new ArrayList<>();
    private int contadorId = 1;
    
    // Crear un nuevo evento
    public Evento crearEvento(String nombre, String descripcion, String fecha, String ubicacion, int capacidad) {
        Evento evento = new Evento(contadorId++, nombre, descripcion, fecha, ubicacion, capacidad);
        eventos.add(evento);
        return evento;
    }
    
    // Obtener todos los eventos
    public List<Evento> obtenerTodos() {
        return eventos;
    }
    
    // Obtener un evento por ID
    public Evento obtenerPorId(int id) {
        for (Evento evento : eventos) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }
    
    // Actualizar un evento
    public Evento actualizar(int id, String nombre, String descripcion, String fecha, String ubicacion, int capacidad) {
        Evento evento = obtenerPorId(id);
        if (evento != null) {
            evento.setNombre(nombre);
            evento.setDescripcion(descripcion);
            evento.setFecha(fecha);
            evento.setUbicacion(ubicacion);
            evento.setCapacidad(capacidad);
        }
        return evento;
    }
    
    // Eliminar un evento
    public boolean eliminar(int id) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getId() == id) {
                eventos.remove(i);
                return true;
            }
        }
        return false;
    }
    
    // Contar eventos totales
    public int contarEventos() {
        return eventos.size();
    }
}
