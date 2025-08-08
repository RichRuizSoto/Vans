package com.example.demo.dao;
import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    public Usuario findByCorreo(String correo);
}
