/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.repositorio;
import com.example.demo.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author nigel
 */
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {}