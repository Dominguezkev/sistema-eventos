package com.eventos.service;

import com.eventos.model.Usuario;
import com.eventos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Registrar un nuevo usuario
    public Usuario registrar(String nombre, String email, String password) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("Ya existe un usuario registrado con ese email");
        }

        String passwordEncriptada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(nombre, email, passwordEncriptada);
        return usuarioRepository.save(usuario);
    }

    // Buscar usuario por email (lo vamos a usar en el login)
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Verificar si una contraseña coincide con la encriptada
    public boolean verificarPassword(String passwordPlano, String passwordEncriptada) {
        return passwordEncoder.matches(passwordPlano, passwordEncriptada);
    }
}
