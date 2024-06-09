import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Album {
    private String nombre;
    private int añoLanzamiento;
    private String disquera;
    private String[] artistas;
    private List<Cancion> canciones;

    private Album(String nombre, int añoLanzamiento, String disquera, String[] artistas) {
        this.nombre = nombre;
        this.añoLanzamiento = añoLanzamiento;
        this.disquera = disquera;
        this.artistas = artistas;
        this.canciones = new ArrayList<Cancion>();
    }

    // Getters and setters

    public String getNombre() {
        return nombre;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    // Función para agregar canción a un álbum
    public void agregarCancion(Cancion cancion) {
        // Verificar si la canción ya existe en el álbum
        for (Cancion c : canciones) {
            if (c.getTitulo().equals(cancion.getTitulo())) {
                System.out.println("La cancion ya existe en el album.");
                return;
            }
        }

        // Agregar la canción al álbum
        canciones.add(cancion);
        System.out.println("Cancion agregada al album.");
    }

    // Función para mostrar álbum
    public void mostrarAlbum() {
        System.out.println("Nombre del album: " + nombre);
        System.out.println("Año de lanzamiento: " + añoLanzamiento);
        System.out.println("Disquera: " + disquera);
        System.out.println("Artistas: " + Arrays.toString(artistas));
        System.out.println("Canciones:");

        if (canciones.isEmpty()) {
            System.out.println("No hay canciones en este álbum.");
        } else {
            for (Cancion cancion : canciones) {
                System.out.println(cancion.getTitulo() + " - " + cancion.getDuracion() + " minutos");
            }
        }
    }

    // Función para buscar álbumes por año
    public static void buscarPorAño(List<Album> albums, int año) {
        List<Album> albumsEncontrados = new ArrayList<>();

        for (Album album : albums) {
            if (album.getAñoLanzamiento() == año) {
                albumsEncontrados.add(album);
            }
        }

        // Imprimir los álbumes encontrados
        if (albumsEncontrados.isEmpty()) {
            System.out.println("No se encontraron albumes lanzados en el año " + año);
        } else {
            System.out.println("Albumes lanzados en el año " + año + ":");
            for (Album album : albumsEncontrados) {
                System.out.println(album.getNombre());
            }
        }
    }

    public static Album crearAlbum(String nombre, int añoLanzamiento, String disquera, String[] artistas) {
        // Verificar que el nombre no esté vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("El nombre del álbum no puede estar vacío.");
            return null;
        }

        // Verificar que la disquera no esté vacía
        if (disquera == null || disquera.trim().isEmpty()) {
            System.out.println("La disquera no puede estar vacía.");
            return null;
        }

        // Verificar que haya al menos un artista
        if (artistas == null || artistas.length == 0) {
            System.out.println("Debe haber al menos un artista.");
            return null;
        }

        // Verificar que el año de lanzamiento no sea negativo ni mayor que 2024
        if (añoLanzamiento < 0 || añoLanzamiento > 2024) {
            System.out.println("El año de lanzamiento no puede ser negativo ni mayor que 2024.");
            return null;
        }

        return new Album(nombre, añoLanzamiento, disquera, artistas);
    }
}
