public class Libro {
    int id;
    String titulo;
    String autor;
    // identificar único para libros
    String isbn;
    String genero;

    // constructor
    public Libro(int idLibro, String tituloLibro, String autorLibro, String isbnLibro, String generoLibro) {
        id = idLibro;
        titulo = tituloLibro;
        autor = autorLibro;
        isbn = isbnLibro;
        genero = generoLibro;
    }

    public boolean coincideId(int id) {
        return this.id == id;
    }
}