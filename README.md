# 🎵 Música App - Proyecto Java con Spring Boot (Consola)

Esta es una aplicación de consola desarrollada en Java que permite registrar cantantes y canciones, realizar búsquedas y almacenar la información en una base de datos PostgreSQL. El proyecto fue desarrollado como parte de un desafío práctico para afianzar conocimientos de Java, JPA y bases de datos.

## 🚀 Funcionalidades

- Registrar datos de cantantes
- Registrar canciones asociadas a cantantes
- Buscar canciones por nombre de cantante
- Listar todos los cantantes registrados

## 🛠 Tecnologías usadas

- Java 17+
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Hibernate
- Maven
- Lombok

## ⚙️ Configuración del proyecto

### Base de datos

Debes tener PostgreSQL instalado y creado un schema llamado `musica_app`. Luego, configura tu `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/musica_app
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update


Ejecutar el proyecto
Clona el repositorio:
git clone https://github.com/ivanfr12/musica_app-sprint-boot-desafio-
cd musica-app

Abre el proyecto en tu IDE (IntelliJ, Eclipse, VS Code, etc.)

Asegúrate de tener PostgreSQL corriendo.

Ejecuta la clase Main.java para iniciar el menú.

📁 Estructura del proyecto
src/main/java/com/tuusuario/musicaapp/
├── modelo/         # Entidades JPA
├── repositorio/    # Interfaces JPA Repository
├── menu/           # Lógica de menú por consola
├── Main.java       # Inicia el menú

+---------------------+
|       INICIO        |
+---------------------+
          |
          v
+---------------------+
|   Mostrar menú      |
+---------------------+
          |
          v
+---------------------+
|   Leer opción       |
+---------------------+
          |
          v
+-----------------------------+
| ¿Qué desea hacer?          |
| (1) Registrar cantante     |
| (2) Registrar canción      |
| (3) Buscar por cantante    |
| (4) Mostrar todos          |
| (0) Salir                  |
+-----------------------------+
     |      |       |       |
     v      v       v       v
 (1) Registrar   (2) Registrar
     cantante        canción
     |               |
     +-------+-------+
             |
             v
     (3) Buscar por cantante
             |
             v
     (4) Mostrar todos
             |
             v
     (0) Salir del sistema
             |
             v
+---------------------+
|        FIN          |
+---------------------+



Autor
Desarrollado por [Ivan Rodriguez] como parte del curso de Alura Latam.
