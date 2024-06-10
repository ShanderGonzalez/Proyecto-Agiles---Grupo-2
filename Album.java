import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * La clase Album representa un álbum de música.
 * Cada álbum tiene un título, un artista y una lista de canciones.
 */
public class Album implements Serializable{
    private static final long serialVersionUID = 1L; // Agregar serialVersionUID
    private String nombre;
    private int añoLanzamiento;
    private String disquera;
    private String[] artistas;
    private List<Cancion> canciones;

    /**
     * Construye un nuevo objeto Album con los detalles dados.
     * 
     * @param nombre          el nombre del álbum
     * @param añoLanzamiento  el año de lanzamiento del álbum
     * @param disquera        el sello discográfico del álbum
     * @param artistas        los artistas asociados al álbum
     */
    private Album(String nombre, int añoLanzamiento, String disquera, String[] artistas) {
        this.nombre = nombre;
        this.añoLanzamiento = añoLanzamiento;
        this.disquera = disquera;
        this.artistas = artistas;
        this.canciones = new ArrayList<Cancion>();
    }

    // Getters and setters

    /**
     * Devuelve el nombre del álbum.
     * 
     * @return el nombre del álbum
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el año de lanzamiento del álbum.
     * 
     * @return el año de lanzamiento del álbum
     */
    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    /**
     * Agrega una canción al álbum.
     * 
     * @param cancion la canción a agregar
     */
    public void agregarCancion(Cancion cancion) {
        for (Cancion c : canciones) {
            if (c.getTitulo().equals(cancion.getTitulo())) {
                System.out.println("La canción ya existe en el álbum.");
                return;
            }
        }
        this.canciones.add(cancion);
        System.out.println("Canción agregada al álbum.");
    }

    /**
     * Muestra los detalles del álbum.
     */
    public void mostrarAlbum() {
        System.out.println("Nombre del álbum: " + nombre);
        System.out.println("Año de lanzamiento: " + añoLanzamiento);
        System.out.println("Sello discográfico: " + disquera);
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

    /**
     * Busca álbumes lanzados en un año específico.
     * 
     * @param albums la lista de álbumes en la que buscar
     * @param año    el año a buscar
     */
    public static void buscarPorAño(List<Album> albums, int año) {
        List<Album> albumsEncontrados = new ArrayList<>();
        for (Album album : albums) {
            if (album.getAñoLanzamiento() == año) {
                albumsEncontrados.add(album);
            }
        }
        if (albumsEncontrados.isEmpty()) {
            System.out.println("No se encontraron álbumes lanzados en el año " + año);
        } else {
            System.out.println("Álbumes lanzados en el año " + año + ":");
            for (Album album : albumsEncontrados) {
                System.out.println(album.getNombre());
            }
        }
    }

    /**
     * Crea un nuevo objeto Album con los detalles dados.
     * 
     * @param nombre          el nombre del álbum
     * @param añoLanzamiento  el año de lanzamiento del álbum
     * @param disquera        el sello discográfico del álbum
     * @param artistas        los artistas asociados al álbum
     * @return el objeto Album recién creado
     */
    public static Album crearAlbum(String nombre, int añoLanzamiento, String disquera, String[] artistas) {
        return new Album(nombre, añoLanzamiento, disquera, artistas);
    }

    public static void guardarAlbumes(List<Album> albumes) {
        try {
            FileOutputStream fileOut = new FileOutputStream("albumes.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(albumes);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static List<Album> cargarAlbumes() {
        List<Album> albumes = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("albumes.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            albumes = (List<Album>) in.readObject();
            in.close();
            fileIn.close();
        } catch (EOFException e) {
            // Fin del archivo alcanzado
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("La clase Album no se encontró");
            c.printStackTrace();
        }
        return albumes;
    }
}
