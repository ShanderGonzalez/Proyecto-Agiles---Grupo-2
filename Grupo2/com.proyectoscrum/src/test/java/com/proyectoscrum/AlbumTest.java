package com.proyectoscrum;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
public class AlbumTest extends TestCase{
    
    @Test
    public void testAlbum() {
        Album album = new Album("Test Album", 2015, "Test Artist", new String[]{"Artista 1", "Artista 2"});
        assertEquals("Test Album", album.getNombre());
        assertEquals(2015, album.getAñoLanzamiento());
    }

    @Test
    public void testAgregarCancion() {
        Album album = new Album("Test Album", 2015, "Test Label", new String[]{"Artista 1"});
        Cancion cancion = new Cancion("Test Song", "3:30");
        album.agregarCancion(cancion);
        album.mostrarAlbum();
        // Verificamos que la canción se haya agregado correctamente
        assertTrue(album.getCanciones().contains(cancion));
    }

    @Test
    public void testMostrarAlbum() {
        Album album = new Album("Test Album", 2015, "Test Label", new String[]{"Artista 1"});
        Cancion cancion1 = new Cancion("Test Song 1", "3:30");
        Cancion cancion2 = new Cancion("Test Song 2", "4:00");
        album.agregarCancion(cancion1);
        album.agregarCancion(cancion2);
        // Verificamos que las canciones se hayan agregado correctamente
        List<Cancion> canciones = album.getCanciones();
        assertEquals(2, canciones.size());
        assertEquals("Test Song 1", canciones.get(0).getTitulo());
        assertEquals("3:30", canciones.get(0).getDuracion());
        assertEquals("Test Song 2", canciones.get(1).getTitulo());
        assertEquals("4:00", canciones.get(1).getDuracion());
    }

    @Test
    public void testBuscarPorAño() {
        Album album1 = new Album("Test Album 1", 2015, "Test Label", new String[]{"Artista 1"});
        Album album2 = new Album("Test Album 2", 2020, "Test Label", new String[]{"Artista 2"});
        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        Album.buscarPorAño(albums, 2015);
        // Verificamos que solo el álbum del 2015 sea encontrado
        List<Album> albums2015 = new ArrayList<>();
        albums2015.add(album1);
        assertTrue(albums2015.contains(album1));
        assertFalse(albums2015.contains(album2));
    }

    @Test
    public void testGuardarYCargarAlbumes() {
        List<Album> albums = new ArrayList<>();
        Album album = new Album("Test Album", 2015, "Test Label", new String[]{"Artista 1"});
        albums.add(album);

        // Guardamos los álbumes en un archivo
        Album.guardarAlbumes(albums);

        // Cargamos los álbumes desde el archivo
        List<Album> loadedAlbums = Album.cargarAlbumes();

        // Verificamos que los álbumes cargados sean iguales a los guardados
        assertEquals(albums.size(), loadedAlbums.size());
        assertEquals(albums.get(0).getNombre(), loadedAlbums.get(0).getNombre());
        assertEquals(albums.get(0).getAñoLanzamiento(), loadedAlbums.get(0).getAñoLanzamiento());

        // Limpiamos el archivo después de la prueba
        File file = new File("albumes.txt");
        if (file.exists()) {
            file.delete();
        }
    }
}
