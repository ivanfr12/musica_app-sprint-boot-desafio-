package com.aluracursos.musica_app.principal;

import com.aluracursos.musica_app.model.Cancion;
import com.aluracursos.musica_app.model.Cantante;
import com.aluracursos.musica_app.repository.CancionRepository;
import com.aluracursos.musica_app.repository.CantanteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {
    private final CantanteRepository cantanteRepo;
    private final CancionRepository cancionRepo;

    public Principal(CantanteRepository cantanteRepo, CancionRepository cancionRepo) {
        this.cantanteRepo = cantanteRepo;
        this.cancionRepo = cancionRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        // Menu
        do {
            System.out.printf("""
                    1 - Registrar Cantante
                    2 - Registrar Canción
                    3 - Buscar Canciones por Cantante
                    0 - Salir
                    """);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    registrarCantante(teclado);
                    break;
                case 2:
                    registrarCancion(teclado);
                    break;
                case 3:
                    buscarCancionesPorCantante(teclado);
                    break;
                default:
                    System.out.printf("Opcion invalida. Intente de nuevo.\n");
            }
        } while (opcion != 0);
    }

    private void registrarCantante(Scanner teclado) {
        System.out.printf("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.printf("Genero musical: ");
        String genero = teclado.nextLine();
        cantanteRepo.save(new Cantante(null, nombre, genero, new ArrayList<>()));
    }

    private void registrarCancion(Scanner teclado) {
        System.out.printf(" Titulo: ");
        String titulo = teclado.nextLine();
        System.out.printf("\n Duracion (segundos): \n");
        int duracion = teclado.nextInt();
        teclado.nextLine();
        System.out.printf("\n Nombre del cantante: \n");
        String nombreCantante = teclado.nextLine();

        Optional<Cantante> cantante = cantanteRepo.findByNombreIgnoreCase(nombreCantante);
        if (cantante.isPresent()) {
            cancionRepo.save(new Cancion(null, titulo, duracion, cantante.get()));
        } else {
            System.out.printf("Cantante no encontrado.");
        }
    }

    private void buscarCancionesPorCantante(Scanner teclado) {
        System.out.printf("Nombre del cantante: ");
        String nombreCantante = teclado.nextLine();
        List<Cancion> canciones = cancionRepo.findByCantanteNombreIgnoreCase(nombreCantante);
        canciones.forEach(c -> System.out.printf(c.getTitulo() + " - " + c.getDuracionEnSegundos() + "s\n"));
    }
}
