## 1. Introducción
### Descripción del Proyecto
"Spotify" es una aplicación diseñada para ayudar a los usuarios a mantener un registro detallado de los álbumes de música que escuchan, incluyendo información básica del álbum y detalles sobre las canciones que lo componen.

### Objetivo
El objetivo de "Spotify" es proporcionar a los usuarios una forma sencilla y organizada de registrar y consultar información sobre sus álbumes de música favoritos. La aplicación permite agregar nuevos álbumes, añadir canciones a los álbumes, evitar duplicados de canciones y buscar álbumes por año de lanzamiento.

### Audiencia
Usuarios apasionados por la música que desean mantener un registro detallado de sus colecciones de álbumes y canciones.

## 2. Requisitos del Sistema
### El programa se puede ejecutar en 3.Ejecutable o en 4.IDE
### **Hardware**
- **Mínimo**: 
  - Procesador: 1 GHz o superior
  - RAM: 512 MB
  - Espacio en Disco: 100 MB
- **Recomendado**: 
  - Procesador: 2 GHz o superior
  - RAM: 2 GB
  - Espacio en Disco: 500 MB

### Software
- **Sistema Operativo**: Windows 7 o superior, macOS 10.12 o superior, Linux (cualquier distribución moderna)
- **Dependencias**:
  - Java Development Kit (JDK) 21
  - Visual Studio Code

## 3. Ejecución
### Instrucciones para la ejecución
   **1.** Descargar el ejecutable de Spotify desde el repositorio de GitHub.
   **2.** Se procede a ejecutar el programa con el siguiente comando:
   ```bash
      java -jar "./ruta/del/ejecutable/Spotify.jar"
   ```
   **3.** Se recomienda guardar el ejecutable en una carpeta, debido a que se genera un archivo "albumes.txt" donde se guarda toda la información generada en la ejecución.

## 4. Instalación IDE
### Instrucciones de Instalación
**1. Descargar e Instalar JDK 21**:
   - Descarga el JDK 21 desde [OpenJDK21U-jdk_x64_windows_hotspot](https://github.com/adoptium/temurin21-binaries/releases/download/jdk-21.0.3+9/OpenJDK21U-jdk_x64_windows_hotspot_21.0.3_9.msi).
   - Ejecuta el instalador y sigue las instrucciones para completar la instalación.

**2. Descargar e Instalar Visual Studio Code**:
   - Descarga Visual Studio Code desde [Visual Studio Code](https://code.visualstudio.com/download).
   - Ejecuta el instalador y sigue las instrucciones para completar la instalación.

**3. Clonar el Repositorio**:
   ```bash
   git clone https://github.com/IsaacFriedman/ProyectoAgiles-Grupo2.git
   ```

**4. Abrir el Proyecto en Visual Studio Code**
    - Abre Visual Studio Code.
    - Selecciona File -> Open Folder y elige la carpeta del proyecto clonado.

### Configuración Inicial
**1. Configurar el Entorno de Desarrollo**:
    - Instala la extensión de Java para Visual Studio Code si no está instalada.
    - Abre el archivo Main.java y verifica que todas las dependencias se resuelvan correctamente.

**2. Compilar y Ejecutar**:
    - Abre el terminal en Visual Studio Code (View -> Terminal).
    - Compila y ejecuta el programa usando cualquiera de los siguientes comandos:
    ```bash
    java Main.java
    java Main
    ```

## 5. Guía de Usuario
### Navegación
   - **Menú Principal**: Acceso a las funciones principales como agregar álbumes, ver álbumes y buscar por año.
   - **Vista de Álbumes**: Lista de todos los álbumes registrados.
   - **Vista de Canciones**: Lista de canciones para un álbum específico.

### Funciones Principales
   - **Agregar Álbum**: Formulario para agregar un nuevo álbum con su nombre, año de lanzamiento, disquera y artistas.
   - **Agregar Canción**: Formulario para agregar canciones a un álbum existente, proporcionando el título y la duración.
   - **Ver Álbumes**: Vista detallada de un álbum con su lista de canciones.
   - **Buscar Álbumes**: Función para buscar álbumes por el año de lanzamiento.

### Ejemplos de Uso
**1. Agregar un Nuevo Álbum**:
   - Selecciona la opción "1. Crear álbum" en el menú principal.
   - Completa las instrucciones ingresando el nombre, año de lanzamiento, disquera y artistas.
   - El álbum se agregará a la lista de álbumes.

**2. Agregar una Canción a un Álbum**:
   - Selecciona la opción "2. Agregar canción a un álbum" en el menú principal.
   - Elige el álbum al que deseas agregar la canción.
   - Completa las instrucciones ingresando el título y la duración de la canción.
   - La canción se agregará al álbum seleccionado.
 
**3. Ver Lista de Canciones de un Álbum**:
   - Selecciona la opción "3. Ver lista de canciones de un álbum" en el menú principal.
   - Elige el álbum del cual deseas ver la lista de canciones.
   - Se mostrará la lista de canciones junto con sus duraciones.

**4. Buscar Álbumes por Año**:
   - Selecciona la opción "4. Buscar álbumes por año" en el menú principal.
   - Ingresa el año por el cual deseas buscar álbumes.
   - Se mostrarán los álbumes lanzados en el año especificado.

## 6. Resolución de Problemas
### Problemas Comunes
   - Error al iniciar el programa: Asegúrate de que todas las dependencias están instaladas correctamente y que el JDK está configurado en el PATH del sistema.
   - Canción duplicada: El sistema evita la adición de canciones con títulos repetidos en un mismo álbum. Verifica el título de la canción que intentas agregar.

## 7. Apéndices 
### Glosario
   - Álbum: Colección de canciones agrupadas bajo un título común.
   - Canción: Composición musical registrada en un álbum
