import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Album> listaDeAlbumes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

/*        Album album1 = Album.crearAlbum("Album1", 2021, "Disquera1", new String[]{"Artista1", "Artista2"});
        album1.agregarCancion(new Cancion("Cancion1", 3));
        album1.agregarCancion(new Cancion("Cancion2", 4));
        listaDeAlbumes.add(album1);*/

        while (true) {
            System.out.println("Seleccione una opcion:\n\n");
            System.out.println("1. Crear album");
            System.out.println("2. Agregar cancion a un album");
            System.out.println("3. Ver lista de canciones de un album");
            System.out.println("4. Buscar albumes por año");
            System.out.println("5. Salir\n");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            if ((opcion == 2 || opcion == 3 || opcion == 4) && listaDeAlbumes.isEmpty()) {
                System.out.println("No hay albumes registrados. \n");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del album: ");
                    System.out.println();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el año de lanzamiento: ");
                    System.out.println();
                    int año = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    System.out.println("Ingrese la disquera: ");
                    System.out.println();
                    String disquera = scanner.nextLine();
                    System.out.println("Ingrese los artistas (separados por coma): ");
                    System.out.println();
                    String[] artistas = scanner.nextLine().split(",");
                    Album album = Album.crearAlbum(nombre, año, disquera, artistas);
                    listaDeAlbumes.add(album);
                    break;
                case 2:
                    System.out.println("Seleccione el album al que desea agregar la cancion: ");
                    System.out.println();
                    for (int i = 0; i < listaDeAlbumes.size(); i++) {
                        System.out.println((i + 1) + ". " + listaDeAlbumes.get(i).getNombre());
                    }
                    int indiceAlbum = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline left-over
                    System.out.println("Ingrese el título de la cancion: ");
                    System.out.println();
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese la duración de la cancion: ");
                    System.out.println();
                    int duracion = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    Cancion cancion = new Cancion(titulo, duracion);
                    listaDeAlbumes.get(indiceAlbum).agregarCancion(cancion);
                    break;
                case 3:
                    System.out.println("Seleccione el album que desea ver: ");
                    System.out.println();
                    for (int i = 0; i < listaDeAlbumes.size(); i++) {
                        System.out.println((i + 1) + ". " + listaDeAlbumes.get(i).getNombre());
                    }
                    int indiceAlbumVer = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline left-over
                    listaDeAlbumes.get(indiceAlbumVer).mostrarAlbum();
                    break;
                case 4:
                    System.out.println("Ingrese el año que desea buscar: ");
                    System.out.println();
                    int añoBuscar = scanner.nextInt();
                    Album.buscarPorAño(listaDeAlbumes, añoBuscar);
                    break;
                case 5:
                    System.out.println("Saliendo...\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.\n");
            }
        }
    }
}