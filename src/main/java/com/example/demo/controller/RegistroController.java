/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.controller;
import com.example.demo.domain.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author nigel
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/registro")
public class RegistroController {

    private final UsuarioRepositorio usuarioRepo;

    @GetMapping
    public String registro() {
        return "registro";
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