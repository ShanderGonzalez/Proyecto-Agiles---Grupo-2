
# Refactorización de Código

## Refactorización en `Album.java`

### Antes
```java
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
```

### Después
```java
/**
 * Crear un nuevo álbum con la información proporcionada.
 * @param nombre el nombre del álbum
 * @param añoLanzamiento el año de lanzamiento del álbum
 * @param disquera la disquera del álbum
 * @param artistas los artistas asociados al álbum
 * @return el objeto Album recién creado
 */
public static Album crearAlbum(String nombre, int añoLanzamiento, String disquera, String[] artistas) {
    return new Album(nombre, añoLanzamiento, disquera, artistas);
}
```
- **Razón:** La verificación de datos se eliminó del método `crearAlbum` para simplificarlo y potencialmente mover la validación a otra capa de lógica o servicio.

### Nuevo Método para Guardar Álbumes
```java
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
```

### Nuevo Método para Cargar Álbumes
```java
public static List<Album> cargarAlbumes() {
    List<Album> albumes = new ArrayList<>();
    try {
        FileInputStream fileIn = new FileInputStream("albumes.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        albumes = (List<Album>) in.readObject();
        in.close();
        fileIn.close();
    } catch (IOException | ClassNotFoundException i) {
        i.printStackTrace();
    }
    return albumes;
}
```
- **Razón:** Añadir funcionalidad para guardar y cargar álbumes desde un archivo, mejorando la persistencia de datos.

## Refactorización en `Main.java`

### Antes
```java
System.out.println("Ingrese el año que desea buscar: ");
System.out.println();
int añoBuscar = scanner.nextInt();
Album.buscarPorAño(listaDeAlbumes, añoBuscar);
```

### Después
```java
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
```
- **Razón:** Mejorar la validación de entrada del año, asegurando que el valor proporcionado sea válido y proporcionando mensajes de error más claros.

## Resumen de Refactorización

- **Eliminación de validaciones del método `crearAlbum` para simplificar su lógica.**
- **Añadidos métodos `guardarAlbumes` y `cargarAlbumes` para la persistencia de datos.**
- **Mejorada la validación de entrada en `Main.java` para buscar álbumes por año.**

Estas refactorizaciones mejoran la legibilidad, mantenibilidad y funcionalidad del código.
