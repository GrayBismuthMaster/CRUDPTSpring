package com.leninvalenzuelapt.prueba.mapper;

import com.leninvalenzuelapt.prueba.dto.LibroDTO;
import com.leninvalenzuelapt.prueba.model.Libro;

public class LibroMapper {
    public static LibroDTO toDTO(Libro libro) {
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setAutor(libro.getAutor());
        libroDTO.setFecha_registro(libro.getFecha_registro());
        return libroDTO;
    }

    public static Libro toEntity(LibroDTO libroDTO) {
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(libroDTO.getAutor());
        libro.setFecha_registro(libroDTO.getFecha_registro());
        return libro;
    }
}
