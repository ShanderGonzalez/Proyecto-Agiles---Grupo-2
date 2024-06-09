public class Cancion {
    private String titulo;
    private int duracion;

    // Constructor
    public Cancion(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }
}
