package com.leninvalenzuelapt.prueba.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.leninvalenzuelapt.prueba.model.Libro;
import com.leninvalenzuelapt.prueba.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {
     private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Page<Libro> getAllLibros(Pageable pageable) {
        return libroRepository.findAll(pageable);
    }

    @Override
    public Libro getLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public void addLibro(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public void updateLibro(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
