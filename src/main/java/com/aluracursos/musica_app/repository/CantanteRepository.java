package com.aluracursos.musica_app.repository;

import com.aluracursos.musica_app.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CantanteRepository  extends JpaRepository<Cantante, Long> {
    Optional<Cantante> findByNombreIgnoreCase(String nombre);
}
