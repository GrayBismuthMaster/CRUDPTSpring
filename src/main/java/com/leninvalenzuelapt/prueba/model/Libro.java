package com.leninvalenzuelapt.prueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")

public class Libro {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String fecha_registro;

    public Libro() {
    }

    public Libro(String titulo, String autor, String fecha_registro) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha_registro = fecha_registro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_libro) {
        this.id = id_libro;
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
    public void updateFields(Libro updatedLibro) {
        if (updatedLibro.getTitulo() != null) {
            this.titulo = updatedLibro.getTitulo();
        }
        if (updatedLibro.getAutor() != null) {
            this.autor = updatedLibro.getAutor();
        }
        
        if (updatedLibro.getFecha_registro() != null) {
            this.autor = updatedLibro.getFecha_registro();
        }
    }
}
