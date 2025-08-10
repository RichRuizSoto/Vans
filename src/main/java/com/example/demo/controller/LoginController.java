/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.controller;
import com.example.demo.domain.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author nigel
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final UsuarioRepositorio usuarioRepo;

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public String procesarLogin(@RequestParam String correo, @RequestParam String contrasena, Model model, HttpSession session) {
        Usuario usuario = usuarioRepo.findByCorreo(correo);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            // Guardar usuario en sesión
            session.setAttribute("usuarioLogeado", usuario);
            return "redirect:/catalogo";
        } else {
            model.addAttribute("error", "Credenciales incorrectas.");
            return "login";
        }
    }
}
