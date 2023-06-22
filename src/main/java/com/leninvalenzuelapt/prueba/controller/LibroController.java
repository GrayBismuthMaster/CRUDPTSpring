package com.leninvalenzuelapt.prueba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leninvalenzuelapt.prueba.dto.LibroDTO;
import com.leninvalenzuelapt.prueba.exception.BadRequestException;
import com.leninvalenzuelapt.prueba.exception.ErrorHandler;
import com.leninvalenzuelapt.prueba.exception.ErrorResponse;
import com.leninvalenzuelapt.prueba.exception.NotFoundException;
import com.leninvalenzuelapt.prueba.model.Libro;
import com.leninvalenzuelapt.prueba.service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private final LibroService libroService;
    private final ErrorHandler errorHandler;

    public LibroController(LibroService libroService, ErrorHandler errorHandler) {
        this.libroService = libroService;
        this.errorHandler = errorHandler;
    }

    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAllLibros() {
        List<Libro> libros = libroService.getAllLibros();
        List<LibroDTO> libroDTOs = new ArrayList<>();
        for (Libro libro : libros) {
            LibroDTO libroDTO = new LibroDTO();
            libroDTO.updateFromLibro(libro);
            libroDTOs.add(libroDTO);
        }
        return ResponseEntity.ok(libroDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> getLibroById(@PathVariable Long id) {
        Libro libro = libroService.getLibroById(id);
        if (libro != null) {
            LibroDTO libroDTO = mapLibroToDTO(libro);
            return ResponseEntity.ok(libroDTO);
        } else {
             throw new NotFoundException("Libro con ID no encontrado: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Void> addLibro(@RequestBody LibroDTO libroDTO) {
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(libroDTO.getAutor());
        libro.setFecha_registro(libroDTO.getFecha_registro());
        libroService.addLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLibro(@PathVariable Long id, @RequestBody Libro updatedLibro) {
        Libro existingLibro = libroService.getLibroById(id);
        if (existingLibro != null) {
            existingLibro.updateFields(updatedLibro); 
            libroService.updateLibro(existingLibro);
            return ResponseEntity.ok().build();
        } else {
                throw new NotFoundException("Libro no encontrado con ID: " + id);
       
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        Libro existingLibro = libroService.getLibroById(id);
        if (existingLibro != null) {
            libroService.deleteLibro(id);
            return ResponseEntity.ok().build();
        } else {
            throw new NotFoundException("Libro no encontrado con ID: " + id);
   
        }
    }

    private LibroDTO mapLibroToDTO(Libro libro) {
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setAutor(libro.getAutor());
        libroDTO.setFecha_registro(libro.getFecha_registro());
        return libroDTO;
    }

     @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
        return errorHandler.handleBadRequestException(ex);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        return errorHandler.handleNotFoundException(ex);
    }
}
