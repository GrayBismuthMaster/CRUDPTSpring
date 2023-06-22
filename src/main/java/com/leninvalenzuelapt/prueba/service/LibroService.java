package com.leninvalenzuelapt.prueba.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.leninvalenzuelapt.prueba.model.Libro;

public interface LibroService {
    Page<Libro> getAllLibros(Pageable pageable);
    Libro getLibroById(Long id);
    void addLibro(Libro libro);
    void updateLibro(Libro libro);
    void deleteLibro(Long id);
}
