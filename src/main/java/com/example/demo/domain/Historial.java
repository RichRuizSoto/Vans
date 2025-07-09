/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
/**
 *
 * @author nigel
 */
@Entity
@Data
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra = new Date();

    private String estado = "Pendiente";
}
