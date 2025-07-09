/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.controller;
import com.example.demo.domain.Usuario;
import com.example.demo.domain.Historial;
import com.example.demo.repositorio.UsuarioRepositorio;
import com.example.demo.repositorio.HistorialRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author nigel
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/historial")
public class HistorialController {

    private final UsuarioRepositorio usuarioRepo;
    private final HistorialRepositorio historialRepo;

    @GetMapping
    public String historial(Model model) {
        model.addAttribute("usuarios", usuarioRepo.findAll());
        return "historial";
    }

    @GetMapping("/{usuarioId}")
    public String historialUsuario(@PathVariable Long usuarioId, Model model) {
        Usuario usuario = usuarioRepo.findById(usuarioId).orElseThrow();
        List<Historial> historial = historialRepo.findByUsuario(usuario);
        model.addAttribute("historial", historial);
        model.addAttribute("usuario", usuario);
        return "historial";
    }
}