    package com.example.demo.model;

    import jakarta.persistence.*;

    @Entity
    @Table(name = "productos")
    public class Producto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id_producto")
        private Long idProducto;
        private String modelo;
        private double precio;
        private String estilo;
        private String imagenUrl;
        private String rutaImagen;
        private boolean activo;
        private int existencias;
        private String detalle;
        private String descripcion;
        
        //@ManyToOne
    //@JoinColumn(name="id_categoria")
    //Categoria categoria;

        // Constructores
        public Producto() {
        }

        public Producto(String descripcion, String modelo, double precio, String estilo, String imagenUrl, boolean activo) {
            this.modelo = modelo;
            this.descripcion = descripcion;
            this.precio = precio;
            this.estilo = estilo;
            this.imagenUrl = imagenUrl;
            this.activo = activo;
        }

        // Getters y Setters
        public Long getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(Long idProducto) {
            this.idProducto = idProducto;
        }
        
        public String getDescripcion(){
            return descripcion;
        }
        
        public void setDescripcion(String descripcion){
            this.descripcion = descripcion;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public double getPrecio() {
            return precio;
        }
        
        public String getRutaImagen(){
            return rutaImagen;
        }
        
        public void setRutaImagen(String rutaImagen){
            this.rutaImagen = rutaImagen;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public String getEstilo() {
            return estilo;
        }

        public void setEstilo(String estilo) {
            this.estilo = estilo;
        }

        public String getImagenUrl() {
            return imagenUrl;
        }

        public void setImagenUrl(String imagenUrl) {
            this.imagenUrl = imagenUrl;
        }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
        
        
    }
    