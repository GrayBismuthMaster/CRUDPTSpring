package com.leninvalenzuelapt.prueba.repository;
import com.leninvalenzuelapt.prueba.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LibroRepository extends JpaRepository<Libro, Long>{
    
}
