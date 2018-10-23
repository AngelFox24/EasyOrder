package com.example.angel.easyorder.Categoria;

public class Categoria {

    private String Titulo;
    private String urlfoto;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public Categoria(String titulo, String urlfoto) {
        this.Titulo = titulo;
        this.urlfoto = urlfoto;
    }

    public Categoria() {
    }
}
