package com.example.demo.dao;
import com.example.demo.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository <Factura, Long>{
    
}
