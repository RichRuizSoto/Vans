/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.controller;
import com.example.demo.domain.Producto;
import com.example.demo.domain.Usuario;
import com.example.demo.domain.Historial;
import com.example.demo.repositorio.ProductoRepositorio;
import com.example.demo.repositorio.UsuarioRepositorio;
import com.example.demo.repositorio.HistorialRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**"C:\Projects\Vans\src\main\java\com\example\demo\controller\CatalogoController.java"
 *
 * @author nigel
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/catalogo")
public class CatalogoController {

    private final ProductoRepositorio productoRepo;
    private final UsuarioRepositorio usuarioRepo;
    private final HistorialRepositorio historialRepo;

    @GetMapping
    public String catalogo(Model model) {
        model.addAttribute("productos", productoRepo.findAll());
        return "catalogo";
    }

    @PostMapping
    public String crearProducto(@RequestParam String nombre, @RequestParam Double precio,
                                @RequestParam Integer cantidad) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setTotal(precio * cantidad);
        productoRepo.save(producto);
        return "redirect:/catalogo";
    }

    @PostMapping("/comprar/{productoId}")
    public String comprar(@PathVariable Long productoId, @RequestParam Long usuarioId) {
        Producto producto = productoRepo.findById(productoId).orElseThrow();
        Usuario usuario = usuarioRepo.findById(usuarioId).orElseThrow();
        Historial historial = new Historial();
        historial.setUsuario(usuario);
        historial.setProducto(producto);
        historialRepo.save(historial);
        producto.setCantidad(producto.getCantidad() - 1);
        producto.setTotal(producto.getPrecio() * producto.getCantidad());
        productoRepo.save(producto);
        return "redirect:/catalogo";
    }
}