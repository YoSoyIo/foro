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
```
# Configurar la Base de Datos
Crea una base de datos en MySQL (o tu gestor de base de datos preferido) y ajusta los parámetros de conexión en el archivo src/main/resources/application.properties.

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
# Dependencias de Maven
Asegúrate de que las dependencias necesarias están incluidas en tu archivo pom.xml.

```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-core</artifactId>
		</dependency>
		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-mysql</artifactId>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>com.auth0</groupId>
			<artifactId>java-jwt</artifactId>
			<version>4.4.0</version>
		</dependency>
	</dependencies>
```
# Ejecutar la Aplicación
Puedes ejecutar la aplicación utilizando Maven.
La aplicación estará disponible en http://localhost:8080.

# Uso de la API
## Endpoints Disponibles
### Crear un Nuevo Tema
URL: /foro
Método: POST
Cuerpo de la Solicitud:
```json
{
	"titulo": "Error BOOT",
	"Mensaje": "Me manda un error",
	"fechaCreacion": "2024-10-10T10:30",
	"status": "NORESUELTA",
	"autor": 1,
	"curso": 1
}
```
### Obtener Todos los Temas
URL: /foro
Método: GET
### Obtener un Tema por ID
URL: /foro/{id}
Método: GET
### Actualizar un Tema
URL: /foro/{id}
Método: PUT
Cuerpo de la Solicitud:
```json
{
	"id": 1,
	"titulo": "Error Entity al ejecutar spring",
	"Mensaje": "No me deja ejecutar el programa y me manda un error y no se como solucionarlo",
	"status": "RESUELTA"
}
```
### Eliminar un Tema
URL: /foro/{id}
Método: DELETE
# Seguridad
Para la configuración de seguridad, se ha personalizado la genercion de un token. Puedes ajustarlo en el paquete Security.
URL: /login
Método: POST
``` json
{
	"jwTtoken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBbHVyYUZvcm8iLCJzdWIiOiJqdWFuIiwiaWQiOjEsImV4cCI6MTcxOTE4Mzk3NH0.zNmYQub96BqwbRQMWRvdMU7tDTZFZOqndD4v-G3qppE"
}
```

