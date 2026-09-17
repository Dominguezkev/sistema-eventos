package com.eventos.service;

import com.eventos.model.Evento;
import com.eventos.repository.EventoRepository;
import com.eventos.exception.EventoNoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventoServiceTest {

    @Mock
    private EventoRepository eventoRepository;

    @InjectMocks
    private EventoService eventoService;

    private Evento evento;

    @BeforeEach
    void setUp() {
        evento = new Evento("Tech Conf", "Descripcion", "2026-09-01", "Online", 100);
        evento.setId(1);
    }

    @Test
    void deberiaCrearUnEvento() {
        // Arrange (preparar)
        when(eventoRepository.save(any(Evento.class))).thenReturn(evento);

        // Act (ejecutar)
        Evento resultado = eventoService.crearEvento("Tech Conf", "Descripcion", "2026-09-01", "Online", 100);

        // Assert (verificar)
        assertNotNull(resultado);
        assertEquals("Tech Conf", resultado.getNombre());
        assertEquals(100, resultado.getCapacidad());
    }

    @Test
    void deberiaObtenerEventoPorId() {
        // Arrange
        when(eventoRepository.findById(1)).thenReturn(Optional.of(evento));

        // Act
        Evento resultado = eventoService.obtenerPorId(1);

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Tech Conf", resultado.getNombre());
    }

    @Test
    void deberiaLanzarExcepcionSiEventoNoExiste() {
        // Arrange
        when(eventoRepository.findById(999)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(EventoNoEncontradoException.class, () -> {
            eventoService.obtenerPorId(999);
        });
    }

    @Test
    void deberiaEliminarUnEvento() {
        // Arrange
        when(eventoRepository.existsById(1)).thenReturn(true);

        // Act
        boolean resultado = eventoService.eliminar(1);

        // Assert
        assertTrue(resultado);
        verify(eventoRepository, times(1)).deleteById(1);
    }
    @Test
    void deberiaActualizarUnEvento() {
        // Arrange
        Evento eventoActualizado = new Evento("Tech Conf 2027", "Nueva descripcion", "2027-01-15", "Cordoba", 200);
        eventoActualizado.setId(1);

        when(eventoRepository.findById(1)).thenReturn(Optional.of(evento));
        when(eventoRepository.save(any(Evento.class))).thenReturn(eventoActualizado);

        // Act
        Evento resultado = eventoService.actualizar(1, "Tech Conf 2027", "Nueva descripcion", "2027-01-15", "Cordoba", 200);

        // Assert
        assertNotNull(resultado);
        assertEquals("Tech Conf 2027", resultado.getNombre());
        assertEquals(200, resultado.getCapacidad());
        verify(eventoRepository, times(1)).save(any(Evento.class));
    }

    @Test
    void deberiaLanzarExcepcionAlActualizarEventoInexistente() {
        // Arrange
        when(eventoRepository.findById(999)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(EventoNoEncontradoException.class, () -> {
            eventoService.actualizar(999, "Nombre", "Desc", "2027-01-01", "Lugar", 50);
        });
    }

    @Test
    void deberiaContarEventosCorrectamente() {
        // Arrange
        when(eventoRepository.count()).thenReturn(5L);

        // Act
        int resultado = eventoService.contarEventos();

        // Assert
        assertEquals(5, resultado);
    }

    @Test
    void deberiaDevolverFalseAlEliminarEventoInexistente() {
        // Arrange
        when(eventoRepository.existsById(999)).thenReturn(false);

        // Act
        boolean resultado = eventoService.eliminar(999);

        // Assert
        assertFalse(resultado);
        verify(eventoRepository, never()).deleteById(anyInt());
    }
}
