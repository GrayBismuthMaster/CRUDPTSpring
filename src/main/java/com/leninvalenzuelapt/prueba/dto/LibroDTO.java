package com.leninvalenzuelapt.prueba.dto;

import com.leninvalenzuelapt.prueba.model.Libro;

// Import statements

public class LibroDTO {
    private String titulo;
    private String autor;
    private String fecha_registro;

    public LibroDTO() {
    }

    public LibroDTO(String titulo, String autor, String fecha_registro) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha_registro = fecha_registro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    
    public void updateFromLibro(Libro libro) {
        this.titulo = libro.getTitulo();
        this.autor = libro.getAutor();
        this.fecha_registro = libro.getFecha_registro();
    }
}