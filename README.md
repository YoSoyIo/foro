# Proyecto de Foro con Spring Boot

Este es un proyecto de ejemplo de un foro desarrollado con Spring Boot.

## Requisitos Previos

Asegúrate de tener instalado lo siguiente en tu entorno de desarrollo:

- Java 11 o superior
- Maven 3.6.3 o superior
- MySQL (u otro gestor de base de datos compatible)

### Clonar el Repositorio

```bash
git clone https://github.com/YoSoyIo/foro.git
cd foro

#Configurar la Base de Datos
Crea una base de datos en MySQL (o tu gestor de base de datos preferido) y ajusta los parámetros de conexión en el archivo src/main/resources/application.properties.

```spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true```
