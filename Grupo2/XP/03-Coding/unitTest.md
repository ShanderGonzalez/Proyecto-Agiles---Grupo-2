# Pruebas Unitarias para la Clase Cancion
Este documento describe las pruebas unitarias implementadas para la clase Cancion en el paquete com.proyectoxp. Las pruebas están escritas utilizando JUnit 5 y están diseñadas para asegurar la funcionalidad correcta de la clase Cancion.

## Clase de Prueba: CancionTest
### Resumen
La clase CancionTest contiene varias pruebas para validar el comportamiento de la clase Cancion. Cada prueba verifica diferentes escenarios, incluyendo casos normales, casos límite y manejo de valores de entrada especiales.

### Pruebas
**1. testCancion**
- Descripción: Prueba la creación de un objeto Cancion con un título y duración válidos.
- Caso de Prueba:
- Título: "Test Title"
- Duración: "3:30"
- Resultado Esperado:
- getTitulo(): "Test Title"
- getDuracion(): "3:30"

**2. testCancionEmptyTitle**
- Descripción: Prueba la creación de un objeto Cancion con un título vacío.
- Caso de Prueba:
- Título: ""
- Duración: "3:30"
- Resultado Esperado:
- getTitulo(): ""
- getDuracion(): "3:30"

**3. testCancionEmptyDuration**
- Descripción: Prueba la creación de un objeto Cancion con una duración vacía.
- Caso de Prueba:
- Título: "Test Title"
- Duración: ""
- Resultado Esperado:
- getTitulo(): "Test Title"
- getDuracion(): ""

**4. testCancionNullTitle**
- Descripción: Prueba la creación de un objeto Cancion con un título nulo.
- Caso de Prueba:
- Título: null
- Duración: "3:30"
- Resultado Esperado:
- getTitulo(): null
- getDuracion(): "3:30"

**5. testCancionNullDuration**
- Descripción: Prueba la creación de un objeto Cancion con una duración nula.
- Caso de Prueba:
- Título: "Test Title"
- Duración: null
- Resultado Esperado:
- getTitulo(): "Test Title"
- getDuracion(): null

**6. testCancionLongDuration**
- Descripción: Prueba la creación de un objeto Cancion con una duración inusualmente larga.
- Caso de Prueba:
- Título: "Test Title"
- Duración: "123:45"
- Resultado Esperado:
- getTitulo(): "Test Title"
- getDuracion(): "123:45"

**7. testCancionLongTitle**
- Descripción: Prueba la creación de un objeto Cancion con un título muy largo.
- Caso de Prueba:
- Título: "A".repeat(1000)
- Duración: "3:30"
- Resultado Esperado:
- getTitulo(): "A" repetido 1000 veces
- getDuracion(): "3:30"

**8. testCancionSpecialCharacters**
- Descripción: Prueba la creación de un objeto Cancion con caracteres especiales en el título.
- Caso de Prueba:
- Título: "Test @#$%^&*()"
- Duración: "3:30"
- Resultado Esperado:
- getTitulo(): "Test @#$%^&*()"
- getDuracion(): "3:30"

### Conclusión
Estas pruebas aseguran que la clase Cancion maneje correctamente varios escenarios, incluyendo valores vacíos, nulos, cadenas largas y caracteres especiales. Los resultados esperados para cada caso de prueba son verificados mediante afirmaciones, proporcionando una validación integral de la funcionalidad de la clase Cancion.

# Pruebas Unitarias para la Clase Album
Este documento detalla las pruebas unitarias implementadas para la clase Album en el paquete com.proyectoxp. Estas pruebas se realizan utilizando JUnit 5 y están diseñadas para verificar el comportamiento correcto de los métodos de la clase Album.

## Clase de Prueba: AlbumTest
Resumen
La clase AlbumTest contiene varias pruebas para evaluar diferentes aspectos de la funcionalidad de la clase Album, incluyendo la creación de álbumes, la adición de canciones, la búsqueda por año y el guardado y carga de álbumes desde un archivo.

### Pruebas
**1. testAlbum**
- Descripción: Verifica la creación de un objeto Album con los parámetros proporcionados.
- Caso de Prueba:
- Nombre del Álbum: "Test Album"
- Año de Lanzamiento: 2015
- Artista Principal: "Test Label"
- Artistas Colaboradores: ["Artista 1", "Artista 2"]
- Resultado Esperado:
- getNombre(): "Test Album"
- getAñoLanzamiento(): 2015

**2. testAgregarCancion**
- Descripción: Verifica la adición de una canción a un álbum.
- Caso de Prueba:
- Álbum: Se crea un álbum con una canción.
- Canción a Agregar: "Test Song" (Duración: "3:30")
- Resultado Esperado:
- La canción se agrega correctamente al álbum.

**3. testMostrarAlbum**
- Descripción: Verifica que las canciones se agreguen correctamente a un álbum y se muestren correctamente.
- Caso de Prueba:
- Álbum: Se crea un álbum con dos canciones.
- Canciones: "Test Song 1" (Duración: "3:30") y "Test Song 2" (Duración: "4:00")
- Resultado Esperado:
- Las canciones se agregan correctamente al álbum y se muestran en el orden esperado.

**4. testBuscarPorAño**
- Descripción: Verifica la funcionalidad de búsqueda de álbumes por año.
- Caso de Prueba:
- Álbumes: Se crean dos álbumes con diferentes años de lanzamiento.
- Año a Buscar: 2015
- Resultado Esperado:
- Solo se encuentra el álbum con el año de lanzamiento especificado.

**5. testGuardarYCargarAlbumes**
- Descripción: Verifica la funcionalidad de guardado y carga de álbumes desde un archivo.
- Caso de Prueba:
- Álbum: Se crea un álbum y se guarda en un archivo.
- Carga de Álbumes: Se carga el álbum desde el archivo.
- Resultado Esperado:
- El álbum cargado es igual al álbum original.

### Conclusión
Estas pruebas garantizan que la clase Album funcione correctamente en diversas situaciones, incluyendo la adición de canciones, búsqueda por año y persistencia de datos mediante el guardado y carga desde un archivo. Se verifica que los resultados sean consistentes y se asegura la integridad de los datos manipulados por la clase Album.