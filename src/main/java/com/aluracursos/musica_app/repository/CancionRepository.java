package com.aluracursos.musica_app.repository;

import com.aluracursos.musica_app.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
    List<Cancion> findByCantanteNombreIgnoreCase(String nombreCantante);
}
