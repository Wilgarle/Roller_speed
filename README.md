# Roller Speed Academy - Sistema de Gestión

Proyecto universitario desarrollado con Spring Boot y MySQL para la gestión de la academia Roller Speed.

## 📋 Requisitos Previos

- **Java JDK 17** o superior
- **MySQL 8.0** o superior
- **Maven 3.6+** (o usar el Maven Wrapper incluido)

## 🚀 Configuración Inicial

### 1. Clonar el Repositorio

```bash
git clone https://github.com/Wilgarle/Roller_speed.git
cd Roller_speed
```

### 2. Configurar la Base de Datos

Ejecuta el script SQL incluido para crear la base de datos y el usuario:

```bash
mysql -u root -p < create-db-template.sql
```

Esto creará:
- Base de datos: `dbroller_speed`
- Usuario: `admin`
- Contraseña: `admin123`

### 3. Verificar Configuración

La configuración de la base de datos está en:
```
v1/src/main/resources/application.properties
```

Credenciales configuradas:
- **URL**: `jdbc:mysql://localhost:3306/dbroller_speed`
- **Usuario**: `admin`
- **Contraseña**: `admin123`
- **Puerto del servidor**: `8080`

## ▶️ Ejecutar el Proyecto

### Opción 1: Con Maven Wrapper (Recomendado)

```bash
cd v1
.\mvnw.cmd spring-boot:run
```

### Opción 2: Con Maven instalado

```bash
cd v1
mvn spring-boot:run
```

### Opción 3: Ejecutar el JAR compilado

```bash
cd v1
.\mvnw.cmd clean package
java -jar target\v1-0.0.1-SNAPSHOT.jar
```

## 🌐 Acceder a la Aplicación

Una vez iniciado el servidor, accede a:

```
http://localhost:8080
```

## 📁 Estructura del Proyecto

```
v1/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/roller_speed_academy/v1/
│   │   │       ├── Controller/        # Controladores MVC
│   │   │       ├── Model/             # Entidades JPA
│   │   │       ├── Repository/        # Repositorios de datos
│   │   │       └── Service/           # Lógica de negocio
│   │   └── resources/
│   │       ├── application.properties # Configuración
│   │       ├── static/                # CSS, JS, imágenes
│   │       └── templates/             # Vistas HTML (Thymeleaf)
│   └── test/                          # Pruebas unitarias
└── pom.xml                            # Dependencias Maven
```

## 🛠️ Tecnologías Utilizadas

- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **MySQL 8** - Base de datos
- **Thymeleaf** - Motor de plantillas
- **Maven** - Gestión de dependencias

## 👥 Equipo de Desarrollo

Proyecto desarrollado por estudiantes de IU Digital - 2025-02

## 📝 Notas para el Equipo

- Asegúrate de tener MySQL corriendo antes de iniciar la aplicación
- Si cambias la configuración de la base de datos, actualiza `application.properties`
- El proyecto usa `spring.jpa.hibernate.ddl-auto=update` para actualizar el esquema automáticamente
- Mantén sincronizado tu repositorio con `git pull` antes de hacer cambios

## ⚠️ Solución de Problemas

### Error de conexión a MySQL
```
Access denied for user 'admin'@'localhost'
```
**Solución**: Verifica que ejecutaste el script `create-db-template.sql`

### Puerto 8080 en uso
**Solución**: Cambia el puerto en `application.properties`:
```properties
server.port=8081
```

### Error de compilación Maven
**Solución**: Limpia y recompila:
```bash
.\mvnw.cmd clean install
```

## 📧 Contacto

Para dudas o problemas, contacta al equipo de desarrollo.
