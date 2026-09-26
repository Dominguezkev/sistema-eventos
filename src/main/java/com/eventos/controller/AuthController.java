package com.eventos.controller;

import com.eventos.dto.LoginRequest;
import com.eventos.dto.RegistroRequest;
import com.eventos.model.Usuario;
import com.eventos.security.JwtService;
import com.eventos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroRequest request) {
        Usuario usuario = usuarioService.registrar(
                request.getNombre(),
                request.getEmail(),
                request.getPassword()
        );

        // No devolvemos la contraseña (ni encriptada) en la respuesta
        return ResponseEntity.ok(Map.of(
                "id", usuario.getId(),
                "nombre", usuario.getNombre(),
                "email", usuario.getEmail(),
                "mensaje", "Usuario registrado con éxito"
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        Usuario usuario = usuarioService.buscarPorEmail(request.getEmail());

        boolean passwordCorrecta = usuarioService.verificarPassword(
                request.getPassword(),
                usuario.getPassword()
        );

        if (!passwordCorrecta) {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        }

        String token = jwtService.generarToken(usuario.getEmail());

        return ResponseEntity.ok(Map.of(
                "token", token,
                "nombre", usuario.getNombre(),
                "email", usuario.getEmail()
        ));
    }
}
