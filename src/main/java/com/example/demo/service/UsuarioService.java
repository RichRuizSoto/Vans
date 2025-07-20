package com.example.demo.service;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
    
    public Usuario guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }
    
    public void eliminar(Long id){
        usuarioRepository.deleteById(id);
    }
    
}
