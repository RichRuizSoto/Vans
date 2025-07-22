package com.example.demo.service.impl;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        if (!usuario.isActivo()) {
            throw new UsernameNotFoundException("Usuario inactivo");
        }

        var roles = usuario.getRoles()
            .stream()
            .map(r -> new SimpleGrantedAuthority(r.getNombre()))
            .collect(Collectors.toList());

        return new User(usuario.getUsername(), usuario.getContraseña(), roles);
    }
}
