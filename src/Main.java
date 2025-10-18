import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Libro> biblioteca = obtenerLibrosIniciales();
        int idSiguiente = biblioteca.size() + 1;
        int opcionUsuario;

        System.out.println("¡Bienvenido al Sistema de Gestión de Biblioteca 📚");
        label:
        while (true) {
            System.out.println("""
                Ingrese el número equivalente a la opción:
                0 - Finalizar programa
                1 - Agregar nuevo libro
                2 - Listar todos los libros
                3 - Búsqueda por título
                4 - Búsqueda por autor
                5 - Buscar por género
                6 - Editar información del libro
                7 - Eliminar libro del catálogo
                """);
            opcionUsuario = entrada.nextInt();

            switch (opcionUsuario) {
                case 1 -> {
                    crearLibro(idSiguiente, biblioteca);
                    idSiguiente += 1;
                }
                case 2 -> listarLibros(biblioteca);
                case 3 -> buscarLibroPorTitulo(biblioteca);
                case 4 -> buscarLibroPorAutor(biblioteca);
                case 5 -> buscarLibroPorGenero(biblioteca);
                case 6 -> editarLibro(biblioteca);
                case 7 -> borrarLibro(biblioteca);
                case 0 -> {
                    System.out.println("¡Gracias por usar el sistema de biblioteca!");
                    break label; // corta el bucle donde se ejecuta
                }
                default -> System.out.println("Opción incorrecta, intente de nuevo");
            }
        }
    }

    public static void crearLibro(int id, ArrayList<Libro> biblioteca) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("AGREGANDO NUEVO LIBRO");
        System.out.print("Ingrese el título del libro: ");
        String titulo = entrada.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = entrada.nextLine();
        System.out.print("Ingrese el ISBN: ");
        String isbn = entrada.nextLine();
        System.out.print("Ingrese el género: ");
        String genero = entrada.nextLine();

        biblioteca.add(new Libro(id, titulo, autor, isbn, genero));
        System.out.println("✅ Libro agregado exitosamente!");
        pausa();
    }

    public static void listarLibros(ArrayList<Libro> biblioteca) {
        System.out.println("CATÁLOGO DE LA BIBLIOTECA");

        if (biblioteca == null || biblioteca.isEmpty()) {
            System.out.println("⚠️  No hay libros en el catálogo.");
        } else {
            for (Libro libro : biblioteca) {
                System.out.printf(" %2d. %-25s | %-15s | %-13s | %s%n",
                        libro.id, libro.titulo, libro.autor, libro.isbn, libro.genero);
            }
        }

        System.out.println("==================================================");
        pausa();
    }

    public static void buscarLibroPorTitulo(ArrayList<Libro> biblioteca) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el título o parte del título: ");
        String busqueda = entrada.nextLine();
        ArrayList<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : biblioteca) {
            if (estaIncluido(libro.titulo, busqueda)) {
                librosEncontrados.add(libro);
            }
        }

        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            System.out.println("Libros encontrados:");
            listarLibros(librosEncontrados);
        }
    }

    public static void buscarLibroPorAutor(ArrayList<Libro> biblioteca) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del autor: ");
        String busqueda = entrada.nextLine();
        ArrayList<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : biblioteca) {
            if (estaIncluido(libro.autor, busqueda)) {
                librosEncontrados.add(libro);
            }
        }

        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros de ese autor.");
        } else {
            System.out.println("Libros encontrados:");
            listarLibros(librosEncontrados);
        }
    }

    public static void buscarLibroPorGenero(ArrayList<Libro> biblioteca) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el género: ");
        String busqueda = entrada.nextLine();
        ArrayList<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : biblioteca) {
            if (estaIncluido(libro.genero, busqueda)) {
                librosEncontrados.add(libro);
            }
        }

        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros de ese género.");
        } else {
            System.out.println("Libros encontrados:");
            listarLibros(librosEncontrados);
        }
    }

    public static void editarLibro(List<Libro> biblioteca) {
        Scanner entrada = new Scanner(System.in);
        Libro libro = obtenerLibroPorId(biblioteca);

        if (libro == null) {
            System.out.println("❌ No se encontró el libro con ese ID.");
            pausa();
            return;
        }

        System.out.println("LIBRO A EDITAR:");
        System.out.println("Título: " + libro.titulo);
        System.out.println("Autor: " + libro.autor);
        System.out.println("ISBN: " + libro.isbn);
        System.out.println("Género: " + libro.genero);

        System.out.print("Ingrese el nuevo título (ENTER para mantener actual): ");
        String nuevoTitulo = entrada.nextLine();
        if (!nuevoTitulo.isEmpty()) libro.titulo = nuevoTitulo;

        System.out.print("Ingrese el nuevo autor (ENTER para mantener actual): ");
        String nuevoAutor = entrada.nextLine();
        if (!nuevoAutor.isEmpty()) libro.autor = nuevoAutor;

        System.out.print("Ingrese el nuevo ISBN (ENTER para mantener actual): ");
        String nuevoIsbn = entrada.nextLine();
        if (!nuevoIsbn.isEmpty()) libro.isbn = nuevoIsbn;

        System.out.print("Ingrese el nuevo género (ENTER para mantener actual): ");
        String nuevoGenero = entrada.nextLine();
        if (!nuevoGenero.isEmpty()) libro.genero = nuevoGenero;

        System.out.println("✅ Libro actualizado exitosamente!");
        pausa();
    }

    public static void borrarLibro(List<Libro> biblioteca) {
        Scanner entrada = new Scanner(System.in);
        Libro libro = obtenerLibroPorId(biblioteca);

        if (libro == null) {
            System.out.println("❌ No se encontró el libro con ese ID.");
            pausa();
            return;
        }

        System.out.println("LIBRO A BORRAR:");
        System.out.println("Título: " + libro.titulo + " | Autor: " + libro.autor);
        System.out.print("¿Está seguro de que desea borrar este libro? (s/n): ");
        String confirmacion = entrada.nextLine();

        if (confirmacion.equals("s") || confirmacion.equals("S")) {
            biblioteca.remove(libro);
            System.out.println("✅ Libro borrado exitosamente!");
        } else {
            System.out.println("Operación cancelada.");
        }
        pausa();
    }

    /* UTILIDADES */
    public static Libro obtenerLibroPorId(List<Libro> biblioteca) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el ID del libro: ");
        int idBusqueda = entrada.nextInt();
        entrada.nextLine(); // limpiar

        for (Libro libro : biblioteca) {
            if (libro.coincideId(idBusqueda)) {
                return libro;
            }
        }
        return null;
    }

    public static boolean estaIncluido(String textoCompleto, String textoParcial) {
        String textoCompletoFormateado = formatoBusqueda(textoCompleto);
        return textoCompletoFormateado.contains(formatoBusqueda(textoParcial));
    }

    public static String formatoBusqueda(String texto) {
        return texto.trim().toLowerCase();
    }

    public static void pausa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Pulse ENTER para continuar...");
        entrada.nextLine();
        for (int i = 0; i < 20; ++i) {
            System.out.println();
        }
    }

    public static ArrayList<Libro> obtenerLibrosIniciales() {
        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro(1, "Cien años de soledad", "Gabriel García Márquez", "978-8437604947", "Realismo mágico"));
        libros.add(new Libro(2, "1984", "George Orwell", "978-0451524935", "Ciencia ficción"));
        libros.add(new Libro(3, "Don Quijote de la Mancha", "Miguel de Cervantes", "978-8424113096", "Novela clásica"));
        libros.add(new Libro(4, "Orgullo y prejuicio", "Jane Austen", "978-0141439518", "Romance"));
        libros.add(new Libro(5, "El principito", "Antoine de Saint-Exupéry", "978-0156012195", "Fabula"));
        libros.add(new Libro(6, "Harry Potter y la piedra filosofal", "J.K. Rowling", "978-8478884452", "Fantasía"));
        libros.add(new Libro(7, "Crónica de una muerte anunciada", "Gabriel García Márquez", "978-0307475348", "Novela"));
        libros.add(new Libro(8, "El nombre del viento", "Patrick Rothfuss", "978-8499082488", "Fantasía épica"));
        libros.add(new Libro(9, "Los juegos del hambre", "Suzanne Collins", "978-8427202122", "Distopía"));
        libros.add(new Libro(10, "It", "Stephen King", "978-1501142970", "Terror"));

        return libros;
    }
}