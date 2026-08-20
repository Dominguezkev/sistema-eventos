package com.eventos.controller;

import com.eventos.model.Evento;
import com.eventos.service.EventoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
    
    private EventoService eventoService = new EventoService();
    
    // GET: obtener todos los eventos
    @GetMapping
    public List<Evento> obtenerTodos() {
        return eventoService.obtenerTodos();
    }
    
    // GET: obtener evento por ID
    @GetMapping("/{id}")
    public Evento obtenerPorId(@PathVariable int id) {
        return eventoService.obtenerPorId(id);
    }
    
    // POST: crear un nuevo evento
    @PostMapping
    public Evento crear(@RequestBody Evento evento) {
        return eventoService.crearEvento(
            evento.getNombre(),
            evento.getDescripcion(),
            evento.getFecha(),
            evento.getUbicacion(),
            evento.getCapacidad()
        );
    }
    
    // PUT: actualizar evento
    @PutMapping("/{id}")
    public Evento actualizar(@PathVariable int id, @RequestBody Evento evento) {
        return eventoService.actualizar(
            id,
            evento.getNombre(),
            evento.getDescripcion(),
            evento.getFecha(),
            evento.getUbicacion(),
            evento.getCapacidad()
        );
    }
    
    // DELETE: eliminar evento
    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return eventoService.eliminar(id);
    }
    
    // GET: contar eventos
    @GetMapping("/count/total")
    public int contar() {
        return eventoService.contarEventos();
    }
}
