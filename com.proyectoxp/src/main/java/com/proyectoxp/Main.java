package com.proyectoxp;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Main es la clase principal del programa que permite interactuar con un almacén de álbumes de música.
 * Proporciona un menú de opciones para crear álbumes, agregar canciones a un álbum, ver la lista de canciones de un álbum
 * y buscar álbumes por año de lanzamiento.
 */
public class Main {
    
    public static void main(String[] args) {
        File archivo = new File("albumes.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo");
                e.printStackTrace();
            }
        }
        List<Album> listaDeAlbumes = Album.cargarAlbumes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nALMACEN DE ALBUMES\n");
            System.out.println("Seleccione una opcion:\n");
            System.out.println("1. Crear album");
            System.out.println("2. Agregar cancion a un album");
            System.out.println("3. Ver lista de canciones de un album");
            System.out.println("4. Buscar albumes por año");
            System.out.println("5. Salir\n");
            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Opcion no valida. Intente de nuevo.\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número entero.\n");
                scanner.nextLine();
                continue;
            }
            if ((opcion == 2 || opcion == 3 || opcion == 4) && listaDeAlbumes.isEmpty()) {
                System.out.println("No hay albumes registrados.\n");
                continue;
            }
            switch (opcion) {
                case 1:
                    String nombre;
                    while (true) {
                        System.out.println("Ingrese el nombre del album:\n");
                        nombre = scanner.nextLine();
                        if (nombre.isEmpty()) {
                            System.out.println("El nombre del album no puede estar vacío. Intente de nuevo.\n");
                            continue;
                        }
                        break;
                    }
                    int año = 0;
                    boolean validYear = false;
                    while (!validYear) {
                        System.out.println("Ingrese el año de lanzamiento:\n");
                        String input = scanner.nextLine();
                        if (input.isEmpty()) {
                            System.out.println("El año no puede estar vacío. Intente de nuevo.\n");
                            continue;
                        }
                        try {
                            año = Integer.parseInt(input);
                            if (año > java.time.Year.now().getValue() || año < 1960) {
                                System.out.println("El año ingresado no es válido. Intente de nuevo.\n");
                            } else {
                                validYear = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese un número entero válido.\n");
                        }
                    }
                    String disquera;
                    while (true) {
                        System.out.println("Ingrese la disquera:\n");
                        disquera = scanner.nextLine();
                        if (disquera.isEmpty()) {
                            System.out.println("El nombre de la disquera no puede estar vacío. Intente de nuevo.\n");
                            continue;
                        }
                        break;
                    }
                    String[] artistas;
                    while (true) {
                        System.out.println("Ingrese los artistas (separados por coma en caso de ser 2 o más):\n");
                        artistas = scanner.nextLine().split(",");
                        if (artistas.length == 0 || artistas[0].isEmpty()) {
                            System.out.println("Debe ingresar al menos un artista. Intente de nuevo.\n");
                            continue;
                        }
                        break;
                    }
                    Album album = Album.crearAlbum(nombre, año, disquera, artistas);
                    listaDeAlbumes.add(album);
                    Album.guardarAlbumes(listaDeAlbumes);
                    break;
                case 2:
                    int indiceAlbum;
                    while (true) {
                        try {
                            System.out.println("Seleccione el album al que desea agregar la cancion:\n");
                            for (int i = 0; i < listaDeAlbumes.size(); i++) {
                                System.out.println((i + 1) + ". " + listaDeAlbumes.get(i).getNombre());
                            }
                            String input = scanner.nextLine();
                            if (input.isEmpty()) {
                                System.out.println("El indice de album no puede estar vacío. Intente de nuevo.\n");
                                continue;
                            }
                            indiceAlbum = Integer.parseInt(input) - 1;
                            if (indiceAlbum < 0 || indiceAlbum >= listaDeAlbumes.size()) {
                                System.out.println("Indice de album no valido. Intente de nuevo.\n");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese un número entero válido.\n");
                        }
                    }
                    String titulo;
                    while (true) {
                        System.out.println("Ingrese el título de la canción:\n");
                        titulo = scanner.nextLine();
                        if (titulo.isEmpty()) {
                            System.out.println("El título de la canción no puede estar vacío. Intente de nuevo.\n");
                            continue;
                        }
                        break;
                    }
                    System.out.println("Ingrese la duración de la canción en minutos (formato mm:ss):\n");
                    String duracion;
                    while (true) {
                        duracion = scanner.nextLine();
                        if (duracion.isEmpty()) {
                            System.out.println("La duración de la canción no puede estar vacía. Intente de nuevo.\n");
                            continue;
                        }
                        if (!duracion.matches("\\d{2}:[0-5][0-9]")) {
                            System.out.println("Formato de duración incorrecto. Intente de nuevo (formato mm:ss).\n");
                            continue;
                        }
                        break;
                    }
                    Cancion cancion = new Cancion(titulo, duracion);
                    listaDeAlbumes.get(indiceAlbum).agregarCancion(cancion);
                    Album.guardarAlbumes(listaDeAlbumes);
                    break;
                case 3:
                    System.out.println("Seleccione el album que desea ver:\n");
                    for (int i = 0; i < listaDeAlbumes.size(); i++) {
                        System.out.println((i + 1) + ". " + listaDeAlbumes.get(i).getNombre());
                    }
                    int indiceAlbumVer;
                    while (true) {
                        try {
                            System.out.println("Ingrese el indice del album:\n");
                            String input = scanner.nextLine();
                            if (input.isEmpty()) {
                                System.out.println("El indice de album no puede estar vacío. Intente de nuevo.\n");
                                continue;
                            }
                            indiceAlbumVer = Integer.parseInt(input) - 1;
                            if (indiceAlbumVer < 0 || indiceAlbumVer >= listaDeAlbumes.size()) {
                                System.out.println("Indice de album no valido. Intente de nuevo.\n");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese un número entero válido.\n");
                        }
                    }
                    listaDeAlbumes.get(indiceAlbumVer).mostrarAlbum();
                    break;
                case 4:
                    int añoBuscar = 0;
                    boolean validYearBuscar = false;
                    while (!validYearBuscar) {
                        System.out.println("Ingrese el año que desea buscar:\n");
                        String input = scanner.nextLine();
                        if (input.isEmpty()) {
                            System.out.println("El año no puede estar vacío. Intente de nuevo.\n");
                            continue;
                        }
                        try {
                            añoBuscar = Integer.parseInt(input);
                            if (añoBuscar > java.time.Year.now().getValue() || añoBuscar < 1960) {
                                System.out.println("El año ingresado no es válido. Intente de nuevo.\n");
                            } else {
                                validYearBuscar = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese un número entero válido.\n");
                        }
                    }
                    Album.buscarPorAño(listaDeAlbumes, añoBuscar);
                    break;
                case 5:
                    System.out.println("Saliendo...\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.\n");
                    break;
            }
        }
    }
}