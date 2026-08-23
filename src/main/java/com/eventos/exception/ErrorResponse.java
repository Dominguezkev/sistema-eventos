package com.eventos.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<String> mensajes;
    
    public ErrorResponse(int status, String error, List<String> mensajes) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.mensajes = mensajes;
    }
    
    // Getters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public int getStatus() {
        return status;
    }
    
    public String getError() {
        return error;
    }
    
    public List<String> getMensajes() {
        return mensajes;
    }
}
