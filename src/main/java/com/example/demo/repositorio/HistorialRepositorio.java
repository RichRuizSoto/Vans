/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.repositorio;

import com.example.demo.domain.Historial;
import com.example.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistorialRepositorio extends JpaRepository<Historial, Long> {
    List<Historial> findByUsuario(Usuario usuario);
}