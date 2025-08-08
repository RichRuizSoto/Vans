package com.example.demo.service.impl;

//import com.example.demo.model.Usuario;
//import com.example.demo.repository.UsuarioDao;
import java.util.Collections;
//import java.util.List;
import org.springframework.security.core.userdetails.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    //@Autowired
    //private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Usuario quemado
        if (username.equals("admin@2025")) {
            return new User("admin@2025", "{noop}1234", Collections.emptyList());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}
