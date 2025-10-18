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

## Estructura del código

El proyecto está compuesto por dos clases principales:

### `Libro.java`
Continene la información de la clase 'Libro':  
**Atributos:**
- `int id`: identificador único del libro.  
- `String titulo`: título del libro.  
- `String autor`: nombre del autor.  
- `String isbn`: código ISBN.  
- `String genero`: género.
---

### 💻 `Main.java`
Contiene operaciones de control de la biblioteca.

**Funciones principales:**
- `crearLibro(...)` → permite agregar un nuevo libro.  
- `listarLibros(...)` → muestra el catálogo completo.  
- `buscarLibroPorTitulo(...)`, `buscarLibroPorAutor(...)`, `buscarLibroPorGenero(...)` → permiten búsquedas específicas.  
- `editarLibro(...)` → actualiza la información de un libro existente.  
- `borrarLibro(...)` → elimina un libro del catálogo.  
- `obtenerLibrosIniciales()` → carga una lista de libros inicial para comenzar.  


