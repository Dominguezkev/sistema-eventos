package com.eventos.repository;

import com.eventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    // Spring Data JPA nos da automáticamente:
    // save(), findAll(), findById(), deleteById(), etc.
}
