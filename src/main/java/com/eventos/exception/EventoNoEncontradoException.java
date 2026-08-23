package com.eventos.exception;

public class EventoNoEncontradoException extends RuntimeException {
    
    public EventoNoEncontradoException(int id) {
        super("Evento con id " + id + " no encontrado");
    }
}
