package com.leninvalenzuelapt.prueba.service;

import java.util.List;

import com.leninvalenzuelapt.prueba.model.Libro;

public interface LibroService {
    List<Libro> getAllLibros();
    Libro getLibroById(Long id);
    void addLibro(Libro libro);
    void updateLibro(Libro libro);
    void deleteLibro(Long id);
}
