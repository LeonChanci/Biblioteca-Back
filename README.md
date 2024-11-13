# Biblioteca-Back
 Proyecto Poli Biblioteca-Back - Spring Boot - Spring Data JPA - MySQL - Heroku

This project was compiled with Java 17

## Development server

The server. Navigate to `http://localhost:9090/`.
The server. Navigate to `https://bibliotecaback-8bde82258989.herokuapp.com/`.

## Enviroment Vars
MYSQL_DB_HOST=jdbc:mysql://localhost
MYSQL_DB_PORT=3306;
MYSQL_DB_NAME_SCHEME=biblioteca;
MYSQL_DB_PASSWORD=admin;
MYSQL_DB_USERNAME=root;

## PROYECTO Biblioteca 
Desarrollar una solución web (desplegada) que le facilite un mejor control sobre los datos de clientes y libros de la Biblioteca, también llevar un registro sobre los libros que los clientes prestan guardando la información en base de datos.Información sobre el clientes (Cedula, Nombres, Apellidos, Dirección, Teléfono)

`Tener en cuenta:`
- Información sobre los Clientes: Identificación, Nombres, Apellidos, Edad, Dirección y Teléfono.
- Información sobre los Libros: Nombre, Descripción, Apellidos, Autores, Categorías y Fecha Publicación.
- Información sobre los Préstamos: Libro prestado, Cliente que hace el préstamo, fecha inicio, fecha final.

`Se requiere:`
- Crear CRUD sobre la información referenciada anteriormente: Clientes, Libros y Préstamos (Guardar información en la BD).
- Desplegar la solución en la NUBE.
- Aprendizaje independiente.

## Arquitectura
Proyecto con Arquitectura en Capas:
- `Back:` Capa de lógica hecha con Java 17 - Spring Boot - Spring Data JPA
  - Ofreciendo Servicios APIs REST.
  - Utilizando GitHub.
- `Front:` Capa de presentación hecha con Angular 18
- `BD:` Capa de persistencia en MySQL
  - JawsDB: Proveedor de Bases de datos como servicio asociado a Heroku.
- `Cloud:` Heroku como plataforma de servicios en la nube para el despliegue de aplicaciones


## Info
Proyecto by Politecnico Colimbiano Jaime Isaza Cadavid
Signature: PROGRAMACIÓN DISTRIBUIDA Y PARALELA
Teacher: Hernando Recaman Chaux
