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
    Date fechaPrestado;
    Date fechaMaxDevolucion;
    boolean devuelto;
}
```
Así, podría llevar un registro de qué libros se prestaron y cuándo se deberían devolver (aquí trabajaría con fechas (?, aunque tal vez se complique), cuáles son los libros más prestados o los usuarios más activos.

También debería modificar la clase 'Libro' y agregar un stock (puesto que si no hay libros disponibles, no se debería poder prestar) y una cantidad de veces que han sido prestados (no me importa qué libro de los muchos que hay por el stock, solo me importa el título que se prestó más veces). 

Además, tal vez me sea conveniente implementar una nueva clase para el Usuariuo en caso de querer saber quiénes son los más activos. No me importa en si quién es esa persona (refiriéndome al nombre, el mail, etc.), solo necesitaría la forma de identificación más simple (un número) y la cantidad de veces que ha pedido un libro a la biblioteca y, al igual que como se hizo para 'Libro', una forma de acceder a su id. 

Entonces, al momento de querer pedir prestado un libro X, se le preguntaría a la persona si es la primera vez que pide un libro de la biblioteca. En caso de que si, se la "ingresa" al sistema con la 'cantidad de libros prestados' en 1. Caso contrario (aquí el usuario ya tiene un registro mayor o igual a 1 en su atributo 'cantidad de veces que ha pedido un libros'), se le sumaría 1 a 'cantidad de libros prestados' de ese usuario. En cualquiera de ambos casos, si la persona confirma que se lleva el libro, se debería la fecha actual y la máxima tolerancia de espera para que se devuelva aquel libro X, se le restaría 1 al stock del título que eligió llevar y se le sumaría 1 a la cantidad de veces que aquel título ha sido prestado. 
