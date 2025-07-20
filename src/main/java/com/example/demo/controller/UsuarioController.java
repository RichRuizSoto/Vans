package com.example.demo.controller;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuariosService;
    @GetMapping
    public List<Usuario> listar(){
        return usuariosService.listar();
    }
    
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario){
        return usuariosService.guardar(usuario);
    }
    
    @GetMapping
    public Usuario buscar(@PathVariable Long id){
        return usuariosService.buscarPorId(id);
    }
    
    @PutMapping
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario actual = usuariosService.buscarPorId(id);
        if (actual != null){
            actual.setNombre(usuario.getNombre());
            actual.setCorreo(usuario.getCorreo());
            actual.setContraseña(usuario.getContraseña());
            actual.setRol(usuario.getRol());
            return usuariosService.guardar(actual);
        }
        return  null;
    }
    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        usuariosService.eliminar(id);
    }
}
