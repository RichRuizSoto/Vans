package com.example.demo.controller;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.example.demo.repository.UsuarioDao;

@Controller
public class LoginController {

    @Autowired
    private UsuarioDao usuarioRepository;

    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String correo = request.getParameter("email");
        String contraseña = request.getParameter("password");

        Usuario usuario = usuarioRepository.findByCorreo(correo);

        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            if (usuario.getRol() == Usuario.Rol.ADMIN) {
                response.sendRedirect("/admin.html");
            } else {
                response.sendRedirect("/catalogo.html");
            }
        } else {
            response.sendRedirect("/login.html?error=true");
        }
    }
}