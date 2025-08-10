/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.controller;
import com.example.demo.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 *
 * @author nigel
 */
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