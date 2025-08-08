package com.example.demo.controller;
import com.example.demo.model.Rol;
import com.example.demo.model.Usuario;
import com.example.demo.dao.RolDao;
import com.example.demo.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private RolDao rolDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        // Encriptar la contraseña
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Setear usuario activo
        usuario.setActivo(true);

        // Asignar rol por defecto, por ejemplo "ROLE_USER"
        Rol rolUsuario = rolDao.findByNombre("ROLE_USER");
        if (rolUsuario == null) {
            rolUsuario = new Rol();
            rolUsuario.setNombre("ROLE_USER");
            rolUsuario = rolDao.save(rolUsuario);
        }

        Set<Rol> roles = new HashSet<>();
        roles.add(rolUsuario);
        usuario.setRoles(roles);

        // Guardar el usuario en la base de datos
        usuarioDao.save(usuario);

        return "redirect:/login?registroExitoso";
    }
}
