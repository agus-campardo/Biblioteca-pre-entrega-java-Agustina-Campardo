# 📚 Sistema de Gestión de Biblioteca

Sistema de consola en Java para administrar catálogos de libros. \n
Pre-Entrega del programa Talento Tech, segundo cuatrimestre 2025. 

## Funcionalidades

El programa permite realizar operaciones relacionadas a la gestión de una biblioteca, incluyendo:

| Opción | Descripción |
|--------|--------------|
| `0` | **Finalizar el programa** |
| `1` | **Agregar nuevo libro** al catálogo |
| `2` | **Listar todos los libros** disponibles |
| `3` | **Buscar libros por título** |
| `4` | **Buscar libros por autor** |
| `5` | **Buscar libros por género** |
| `6` | **Editar información de un libro** (nombre, autor, ISBN, género) existente |
| `7` | **Eliminar un libro** del catálogo |

## Estructura 

### `Libro.java`
Clase que representa un libro con sus atributos:
- `id`
- `titulo`
- `autor`
- `isbn`
- `genero`

Tiene un constructor y un método `coincideId(int id)` para buscar por ID.

### `Main.java`
Menú principal y funciones que gestionan la biblioteca:
- **crearLibro()**: agrega un libro nuevo.  
- **listarLibros()**: muestra todos los libros (el catálogo).  
- **buscarLibroPorTitulo()**, **buscarLibroPorAutor()**, **buscarLibroPorGenero()**: buscan libros según criterio.  
- **editarLibro()**: para modificar datos de un libro.  
- **borrarLibro()**: eliminar un libro del catálogo.  
- **obtenerLibrosIniciales()**: una lista inicial de libros.

## Idea para futura implementación

Como se trata de una biblioteca, no solo debería poder **agregar** o **buscar libros**, sino también **prestar** y **registrar préstamos**.

Una posible mejora sería crear una clase `Prestamo` que permita guardar la información de cada préstamo, por ejemplo:

```java
class Prestamo {
    int idPrestamo;
    int idLibro;
    int idUsuario;
    Date fechaPrestamo;
    Date fechaDevolucion;
    boolean devuelto;
}
Así, podría llevar un registro de qué libros se prestaron y cuándo se deberían devolver, cuáles son los libros más prestados o los usuarios más activos. 
También debería modificar la clase 'Libro' y agregar un stock, puesto que si no hay libros disponibles, no se debería poder prestar.
