    package com.example.demo.controller;

    import com.example.demo.model.Producto;
    import com.example.demo.service.ProductoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/productos")
    public class ProductoController {

        @Autowired
        private ProductoService productoService;

        @GetMapping
        public List<Producto> obtenerTodosLosProductos() {
            return productoService.listarTodos();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
            Optional<Producto> producto = productoService.buscarPorId(id);
            return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public Producto crearProducto(@RequestBody Producto producto) {
            return productoService.guardar(producto);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles) {
            Optional<Producto> productoOptional = productoService.buscarPorId(id);
            if (productoOptional.isPresent()) {
                Producto productoExistente = productoOptional.get();
                productoExistente.setModelo(productoDetalles.getModelo());
                productoExistente.setPrecio(productoDetalles.getPrecio());
                productoExistente.setEstilo(productoDetalles.getEstilo());
                productoExistente.setImagenUrl(productoDetalles.getImagenUrl());
                return ResponseEntity.ok(productoService.guardar(productoExistente));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
            if (productoService.buscarPorId(id).isPresent()) {
                productoService.eliminar(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }
    