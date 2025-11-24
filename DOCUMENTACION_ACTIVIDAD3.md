# 📘 Documentación del Proyecto Roller Speed Academy

## Actividad 3 - Implementación de Servicios CRUD y Documentación OpenAPI

---

## 📋 Resumen Ejecutivo

Se ha implementado exitosamente el sistema de servicios REST para la aplicación Roller Speed Academy, incluyendo:

- ✅ Configuración completa de OpenAPI/Swagger
- ✅ Servicios CRUD completos para gestión de usuarios
- ✅ Documentación exhaustiva de endpoints
- ✅ Aplicación de principios SOLID
- ✅ Manejo centralizado de excepciones
- ✅ DTOs para separación de capas

---

## 🏗️ Arquitectura del Sistema

### Estructura de Capas (Siguiendo MVC)

```
v1/
├── Controller/
│   ├── IndexController.java          # Controlador web (vistas)
│   ├── UsuariosController.java       # Controlador web (vistas)
│   └── UsuarioRestController.java    # ✨ NUEVO: API REST endpoints
├── Service/
│   ├── UsuarioService.java           # ✨ Interfaz del servicio
│   └── UsuarioServiceImpl.java       # ✨ Implementación del servicio
├── Repository/
│   └── UsuarioRepository.java        # Acceso a datos (JPA)
├── Model/
│   └── UsuarioModel.java             # Entidad JPA
├── DTO/
│   ├── UsuarioDTO.java               # ✨ NUEVO: DTO de respuesta
│   └── UsuarioRequestDTO.java        # ✨ NUEVO: DTO de entrada
├── Exception/
│   ├── ResourceNotFoundException.java # ✨ NUEVO: Excepción personalizada
│   ├── BusinessException.java         # ✨ NUEVO: Excepción de negocio
│   ├── ErrorResponse.java             # ✨ NUEVO: Respuesta de error
│   └── GlobalExceptionHandler.java    # ✨ NUEVO: Manejador global
└── Config/
    └── OpenApiConfig.java             # ✨ NUEVO: Configuración Swagger
```

---

## 🎯 Principios SOLID Aplicados

### 1. **S - Single Responsibility Principle (SRP)**

Cada clase tiene una única responsabilidad:

- **UsuarioService**: Define contrato de servicios de usuario
- **UsuarioServiceImpl**: Implementa lógica de negocio
- **UsuarioRestController**: Maneja peticiones HTTP
- **GlobalExceptionHandler**: Gestiona excepciones
- **OpenApiConfig**: Configura documentación

### 2. **O - Open/Closed Principle (OCP)**

Clases abiertas para extensión, cerradas para modificación:

- Interfaces como `UsuarioService` permiten múltiples implementaciones
- `GlobalExceptionHandler` puede extenderse con nuevos manejadores

### 3. **L - Liskov Substitution Principle (LSP)**

`UsuarioServiceImpl` puede sustituir a `UsuarioService` sin afectar funcionalidad

### 4. **I - Interface Segregation Principle (ISP)**

- DTOs específicos para diferentes propósitos (UsuarioDTO vs UsuarioRequestDTO)
- Interfaces con métodos específicos y necesarios

### 5. **D - Dependency Inversion Principle (DIP)**

Las capas superiores dependen de abstracciones:

```java
// Controller depende de la interfaz, no de la implementación
private final UsuarioService usuarioService; // ✅ Interfaz

// NO:
// private final UsuarioServiceImpl usuarioService; // ❌ Implementación
```

---

## 📡 Endpoints REST Implementados

### Base URL: `http://localhost:8080/api/v1/usuarios`

| Método | Endpoint | Descripción | Código Respuesta |
|--------|----------|-------------|------------------|
| GET | `/` | Obtener todos los usuarios | 200 OK |
| GET | `/{id}` | Obtener usuario por ID | 200 OK / 404 Not Found |
| POST | `/` | Crear nuevo usuario | 201 Created |
| PUT | `/{id}` | Actualizar usuario | 200 OK / 404 Not Found |
| DELETE | `/{id}` | Eliminar usuario | 204 No Content / 404 Not Found |

### Ejemplos de Uso

#### 1. Crear Usuario (POST)

**Request:**
```http
POST http://localhost:8080/api/v1/usuarios
Content-Type: application/json

{
  "nombreUsuario": "juan.perez",
  "contrasena": "Password123!"
}
```

**Response (201 Created):**
```json
{
  "idUsuario": 1,
  "nombreUsuario": "juan.perez"
}
```

#### 2. Obtener Todos los Usuarios (GET)

**Request:**
```http
GET http://localhost:8080/api/v1/usuarios
```

**Response (200 OK):**
```json
[
  {
    "idUsuario": 1,
    "nombreUsuario": "juan.perez"
  },
  {
    "idUsuario": 2,
    "nombreUsuario": "maria.gomez"
  }
]
```

#### 3. Obtener Usuario por ID (GET)

**Request:**
```http
GET http://localhost:8080/api/v1/usuarios/1
```

**Response (200 OK):**
```json
{
  "idUsuario": 1,
  "nombreUsuario": "juan.perez"
}
```

#### 4. Actualizar Usuario (PUT)

**Request:**
```http
PUT http://localhost:8080/api/v1/usuarios/1
Content-Type: application/json

{
  "nombreUsuario": "juan.perez.updated",
  "contrasena": "NewPassword456!"
}
```

**Response (200 OK):**
```json
{
  "idUsuario": 1,
  "nombreUsuario": "juan.perez.updated"
}
```

#### 5. Eliminar Usuario (DELETE)

**Request:**
```http
DELETE http://localhost:8080/api/v1/usuarios/1
```

**Response (204 No Content)**

---

## 📚 Documentación con Swagger/OpenAPI

### Acceso a la Documentación

Una vez iniciada la aplicación, accede a:

1. **Swagger UI (Interfaz Interactiva):**
   ```
   http://localhost:8080/swagger-ui.html
   ```

2. **API Docs (JSON):**
   ```
   http://localhost:8080/api-docs
   ```

### Características de la Documentación

- 📖 **Descripción completa** de cada endpoint
- 📝 **Ejemplos de entrada** y salida
- 🔄 **Pruebas interactivas** desde el navegador
- ⚠️ **Códigos de respuesta** documentados
- 📋 **Esquemas de datos** con validaciones

---

## 🛡️ Manejo de Errores

### Respuestas de Error Estandarizadas

Todas las respuestas de error siguen esta estructura:

```json
{
  "timestamp": "2025-11-24T12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Usuario no encontrado con ID: 999",
  "path": "/api/v1/usuarios/999"
}
```

### Validaciones

Los datos de entrada son validados automáticamente:

```json
{
  "timestamp": "2025-11-24T12:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Error de validación en los datos de entrada",
  "path": "/api/v1/usuarios",
  "validationErrors": {
    "nombreUsuario": "El nombre de usuario debe tener entre 3 y 50 caracteres",
    "contrasena": "La contraseña es obligatoria"
  }
}
```

---

## 🚀 Cómo Ejecutar el Proyecto

### Requisitos Previos

- Java JDK 17 o superior
- MySQL 8.0 o superior
- Maven 3.6+

### Paso 1: Configurar Base de Datos

Ejecuta el script SQL:

```sql
CREATE DATABASE rollerspeed DEFAULT CHARACTER SET = 'utf8mb4';
USE rollerspeed;
-- Configura usuario y permisos según tu entorno
```

### Paso 2: Configurar Credenciales

Edita `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rollerspeed
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
```

### Paso 3: Ejecutar la Aplicación

```bash
cd v1
mvn spring-boot:run
```

### Paso 4: Verificar Funcionamiento

1. Accede a: `http://localhost:8080/swagger-ui.html`
2. Prueba los endpoints desde la interfaz de Swagger
3. Verifica que los datos se almacenen en MySQL

---

## 📦 Dependencias Agregadas

```xml
<!-- SpringDoc OpenAPI (Swagger) -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.7.0</version>
</dependency>

<!-- Validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

---

## 🔧 Configuraciones Importantes

### application.properties

```properties
# OpenAPI / Swagger Configuration
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operationsSorter=method
springdoc.swagger-ui.tagsSorter=alpha
springdoc.swagger-ui.tryItOutEnabled=true

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false

# Logging Configuration
logging.level.com.roller_speed_academy.v1=INFO
```

---

## 📝 Pruebas Recomendadas

### 1. Pruebas Manuales con Swagger

1. Abrir `http://localhost:8080/swagger-ui.html`
2. Probar cada endpoint en el siguiente orden:
   - POST (crear usuario)
   - GET (listar todos)
   - GET /{id} (obtener específico)
   - PUT (actualizar)
   - DELETE (eliminar)

### 2. Pruebas con Postman/Thunder Client

Importa la colección desde `/api-docs` para pruebas automatizadas

### 3. Pruebas de Validación

Intenta crear usuarios con datos inválidos:
- Nombre muy corto (< 3 caracteres)
- Contraseña muy corta (< 6 caracteres)
- Campos vacíos

---

## 🎓 Conceptos Clave Implementados

### 1. **DTOs (Data Transfer Objects)**

Separan la representación de datos de la entidad de base de datos:
- `UsuarioRequestDTO`: Para recibir datos del cliente
- `UsuarioDTO`: Para enviar datos al cliente

### 2. **Repository Pattern**

`UsuarioRepository` abstrae el acceso a datos usando Spring Data JPA

### 3. **Service Layer**

`UsuarioServiceImpl` contiene la lógica de negocio, separada del controlador

### 4. **REST Best Practices**

- Uso correcto de verbos HTTP
- Códigos de estado apropiados
- URLs semánticas
- Respuestas consistentes

### 5. **Exception Handling**

Manejo centralizado y consistente de errores en toda la aplicación

---

## 📊 Diagrama de Flujo de Peticiones

```
Cliente HTTP
    ↓
UsuarioRestController (Validación de entrada)
    ↓
UsuarioService (Lógica de negocio)
    ↓
UsuarioRepository (Acceso a BD)
    ↓
MySQL Database
    ↓
UsuarioModel → UsuarioDTO (Transformación)
    ↓
Respuesta JSON al Cliente
```

---

## ✅ Checklist de Entregables

- [x] Configuración de OpenAPI/Swagger
- [x] Implementación de servicios CRUD
- [x] Documentación completa de endpoints
- [x] Aplicación de principios SOLID
- [x] Manejo de excepciones
- [x] DTOs para separación de capas
- [x] Validaciones de entrada
- [x] Código subido a GitHub
- [x] README.md con instrucciones
- [x] Documentación técnica completa

---

## 👥 Información del Equipo

**Proyecto**: Roller Speed Academy  
**Institución**: IU Digital  
**Período**: 2025-02  
**Repositorio**: https://github.com/Wilgarle/Roller_speed

---

## 📞 Soporte y Documentación Adicional

### URLs Importantes

- **Aplicación Web**: `http://localhost:8080`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **API Docs JSON**: `http://localhost:8080/api-docs`
- **Repositorio GitHub**: `https://github.com/Wilgarle/Roller_speed`

### Recursos de Aprendizaje

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [SpringDoc OpenAPI](https://springdoc.org/)
- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [REST API Best Practices](https://restfulapi.net/)

---

## 🎬 Conclusión

Este proyecto demuestra la implementación exitosa de:

1. **Arquitectura en capas** con separación de responsabilidades
2. **API REST** siguiendo estándares y mejores prácticas
3. **Documentación automatizada** con OpenAPI/Swagger
4. **Principios SOLID** para código mantenible y escalable
5. **Manejo profesional de errores** y validaciones

La aplicación está lista para ser extendida con nuevas funcionalidades y puede servir como base para el desarrollo continuo del sistema Roller Speed Academy.

---

**Fecha de Documentación**: Noviembre 24, 2025  
**Versión**: 1.0.0  
**Estado**: ✅ Completado y Funcional
