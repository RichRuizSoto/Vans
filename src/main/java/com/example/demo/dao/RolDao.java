package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Rol;

@Repository
public interface RolDao extends JpaRepository<Rol, Long> {
    Rol findByNombre(String nombre);
}
