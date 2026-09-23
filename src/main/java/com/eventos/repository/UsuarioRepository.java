package com.eventos.repository;

import com.eventos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Método personalizado: buscar un usuario por su email
    Optional<Usuario> findByEmail(String email);

    // Verificar si ya existe un usuario con ese email
    boolean existsByEmail(String email);
}
