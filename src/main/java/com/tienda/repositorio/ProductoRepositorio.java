package com.tienda.repositorio;

import com.tienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author nigel
 */
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {}