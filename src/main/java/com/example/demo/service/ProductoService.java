    package com.example.demo.service;

    import com.example.demo.dao.ProductoDao;
import com.example.demo.model.Item;
    import com.example.demo.model.Producto;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ProductoService {

        @Autowired
        private ProductoDao productoDao;

        public List<Producto> listarTodos() {
            return productoDao.findAll();
        }

        public Optional<Producto> buscarPorId(Long id) {
            return productoDao.findById(id);
        }

        public Producto guardar(Producto producto) {
            return productoDao.save(producto);
        }

        public void eliminar(Long id) {
            productoDao.deleteById(id);
        }

    public Producto getProducto(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
    