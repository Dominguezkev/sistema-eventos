package com.eventos.service;

import com.eventos.exception.EventoNoEncontradoException;
import com.eventos.model.Evento;
import com.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    
    @Autowired
    private EventoRepository eventoRepository;
    
    // Crear un nuevo evento
    public Evento crearEvento(String nombre, String descripcion, String fecha, String ubicacion, int capacidad) {
        Evento evento = new Evento(nombre, descripcion, fecha, ubicacion, capacidad);
        return eventoRepository.save(evento);
    }
    
    // Obtener todos los eventos
    public List<Evento> obtenerTodos() {
        return eventoRepository.findAll();
    }
    
    // Obtener un evento por ID
    public Evento obtenerPorId(int id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new EventoNoEncontradoException(id));
    }
    
    // Actualizar un evento
    public Evento actualizar(int id, String nombre, String descripcion, String fecha, String ubicacion, int capacidad) {
        Evento evento = eventoRepository.findById(id)
            .orElseThrow(() -> new EventoNoEncontradoException(id));
    
        evento.setNombre(nombre);
        evento.setDescripcion(descripcion);
        evento.setFecha(fecha);
        evento.setUbicacion(ubicacion);
        evento.setCapacidad(capacidad);
        return eventoRepository.save(evento);
}
    
    // Eliminar un evento
    public boolean eliminar(int id) {
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Contar eventos totales
    public int contarEventos() {
        return (int) eventoRepository.count();
    }
}
