package com.tienda.controller;

import com.tienda.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UsuarioEnSesion {

    @ModelAttribute
    public void agregarUsuarioEnModelo(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogeado");
        if (usuario != null) {
            model.addAttribute("usuarioSesion", usuario);
        }
    }
}