package com.example.angel.easyorder.Producto;

public class Producto {
    String producto;
    double costo;
    String categoria;
    String urlFoto;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Producto(String producto, double costo, String categoria, String urlFoto) {
        this.producto = producto;
        this.costo = costo;
        this.categoria = categoria;
        this.urlFoto = urlFoto;
    }

    public Producto() {
    }
}
