package com.tienda.controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.tienda.domain.Usuario;
import com.tienda.repositorio.UsuarioRepositorio;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registro")
public class RegistroController {

    private final UsuarioRepositorio usuarioRepo;

    @GetMapping
    public String registro() {
        return "registro/listado"; // 🟢 esto sí existe
    }

    @PostMapping
    public String crearUsuario(@RequestParam String nombre, @RequestParam String correo,
                               @RequestParam String direccion, @RequestParam String contrasena) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setDireccion(direccion);
        usuario.setContrasena(contrasena);
        usuarioRepo.save(usuario);
        return "redirect:/login";
    }
}