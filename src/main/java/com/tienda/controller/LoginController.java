package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import com.tienda.domain.Usuario;
import com.tienda.repositorio.UsuarioRepositorio;


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
