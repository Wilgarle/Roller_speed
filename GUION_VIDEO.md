# 🎬 Guion para Video - Actividad 3: Servicios CRUD con OpenAPI
## Roller Speed Academy

**Duración Total:** 4-5 minutos  
**Participantes:** 4 personas  
**Formato:** Presentación técnica colaborativa

---

## 👥 **Distribución de Roles**

- **Persona 1:** Introducción y Arquitectura General
- **Persona 2:** Demostración de Swagger UI y Endpoints
- **Persona 3:** Explicación del Código y Principios SOLID
- **Persona 4:** Pruebas en Vivo y Conclusiones

---

## 📝 **GUION DETALLADO**

### 🎬 **ESCENA 1: Introducción (45 segundos)**
**[Persona 1 en pantalla]**

**Texto a decir:**
> "Hola, somos el equipo [NOMBRE DEL EQUIPO] de IU Digital. En este video presentamos la Actividad 3: Implementación de Servicios CRUD con Documentación OpenAPI para el proyecto Roller Speed Academy.
>
> Durante esta presentación veremos:
> - La arquitectura del sistema implementada
> - La documentación automática con Swagger
> - Los principios SOLID aplicados
> - Y una demostración en vivo de los servicios funcionando.
>
> Comencemos con la arquitectura general del proyecto."

**[Mostrar en pantalla:]**
- Logo o título del proyecto
- Nombres de los integrantes
- Objetivos de la actividad

---

### 🏗️ **ESCENA 2: Arquitectura del Sistema (1 minuto)**
**[Persona 1 continúa - Compartir pantalla VS Code]**

**Texto a decir:**
> "Implementamos una arquitectura en capas siguiendo el patrón MVC y los principios SOLID. Como pueden ver en la estructura del proyecto:
>
> [Navegar por las carpetas en VS Code]
> - La capa **Controller** maneja las peticiones HTTP con UsuarioRestController
> - La capa **Service** contiene la lógica de negocio con UsuarioService y su implementación
> - La capa **Repository** gestiona el acceso a datos con JPA
> - La capa **DTO** separa los datos de entrada y salida
> - Y tenemos manejo centralizado de excepciones con GlobalExceptionHandler
>
> También agregamos la configuración de OpenAPI para documentación automática.
>
> Ahora, mi compañero [NOMBRE PERSONA 2] nos mostrará cómo funciona Swagger."

**[Acciones en pantalla:]**
1. Mostrar estructura de carpetas en VS Code
2. Hacer zoom a cada carpeta mencionada
3. Abrir brevemente 2-3 archivos clave

---

### 📚 **ESCENA 3: Swagger UI y Documentación (1 minuto)**
**[Persona 2 en pantalla - Compartir navegador]**

**Texto a decir:**
> "Gracias [NOMBRE PERSONA 1]. Como pueden ver, accedemos a Swagger UI en localhost:8080/swagger-ui.html
>
> [Mostrar la interfaz de Swagger]
> Aquí tenemos nuestra API REST completamente documentada. Implementamos los 5 endpoints del CRUD:
> 
> 1. **GET /usuarios** - Obtener todos los usuarios
> 2. **GET /usuarios/{id}** - Obtener un usuario específico
> 3. **POST /usuarios** - Crear un nuevo usuario
> 4. **PUT /usuarios/{id}** - Actualizar un usuario
> 5. **DELETE /usuarios/{id}** - Eliminar un usuario
>
> Cada endpoint está documentado con:
> - Descripción detallada de su función
> - Parámetros requeridos
> - Ejemplos de entrada
> - Códigos de respuesta posibles
> - Y esquemas de datos
>
> La documentación se genera automáticamente desde las anotaciones en el código. Ahora [NOMBRE PERSONA 3] nos explicará el código."

**[Acciones en pantalla:]**
1. Abrir http://localhost:8080/swagger-ui.html
2. Desplegar cada endpoint uno por uno
3. Mostrar el esquema de UsuarioDTO
4. Mostrar ejemplos de respuesta

---

### 💻 **ESCENA 4: Código y Principios SOLID (1 minuto 15 segundos)**
**[Persona 3 en pantalla - Compartir VS Code]**

**Texto a decir:**
> "Perfecto, ahora veamos cómo aplicamos los principios SOLID en nuestro código.
>
> [Abrir UsuarioRestController.java]
> En el **Controller**, aplicamos el principio de Responsabilidad Única (SRP). Este controlador solo maneja peticiones HTTP y delega la lógica al servicio.
>
> [Abrir UsuarioService.java]
> Aquí vemos el principio de Inversión de Dependencias (DIP). Definimos una interfaz que abstrae la implementación.
>
> [Abrir UsuarioServiceImpl.java]
> La implementación contiene toda la lógica de negocio. Esto nos permite cambiar la implementación sin afectar el controlador.
>
> [Abrir GlobalExceptionHandler.java]
> El manejo de excepciones está centralizado, aplicando el principio de Abierto/Cerrado (OCP). Podemos agregar nuevos manejadores sin modificar el código existente.
>
> [Abrir UsuarioDTO.java y UsuarioRequestDTO.java]
> Y separamos los DTOs por propósito, aplicando el principio de Segregación de Interfaces (ISP).
>
> Todas las clases tienen validaciones y documentación completa. Ahora [NOMBRE PERSONA 4] nos mostrará las pruebas en vivo."

**[Acciones en pantalla:]**
1. Abrir y mostrar brevemente cada clase mencionada
2. Resaltar anotaciones importantes (@RestController, @Service, @RestControllerAdvice)
3. Mostrar comentarios de documentación

---

### 🧪 **ESCENA 5: Demostración en Vivo (1 minuto 30 segundos)**
**[Persona 4 en pantalla - Compartir navegador en Swagger]**

**Texto a decir:**
> "Excelente explicación. Ahora vamos a probar los servicios en tiempo real usando la interfaz de Swagger.
>
> **Primero, creemos un usuario:**
> [Click en POST /usuarios > Try it out]
> Ingresamos los datos: nombreUsuario 'juan.perez' y contraseña 'Password123'
> [Ejecutar]
> Como vemos, retorna código 201 Created con el usuario creado y su ID.
>
> **Ahora obtengamos todos los usuarios:**
> [Click en GET /usuarios > Try it out > Execute]
> Perfecto, retorna la lista con el usuario que acabamos de crear.
>
> **Consultemos un usuario específico:**
> [Click en GET /usuarios/{id} > Try it out > Ingresar ID > Execute]
> Retorna código 200 con los datos del usuario.
>
> **Actualicemos el usuario:**
> [Click en PUT /usuarios/{id} > Try it out > Modificar datos > Execute]
> Usuario actualizado correctamente con código 200.
>
> **Y probemos las validaciones:**
> [Intentar crear un usuario con datos inválidos]
> Como ven, el sistema valida los datos y retorna código 400 con los errores específicos.
>
> **Finalmente, eliminemos el usuario:**
> [Click en DELETE /usuarios/{id} > Execute]
> Código 204, usuario eliminado exitosamente.
>
> Todas las operaciones CRUD funcionan perfectamente y están documentadas."

**[Acciones en pantalla:]**
1. Ejecutar cada operación mencionada en orden
2. Mostrar claramente las respuestas
3. Resaltar los códigos de estado HTTP
4. Mostrar tanto casos exitosos como errores de validación

---

### 🎯 **ESCENA 6: Conclusiones (30 segundos)**
**[Persona 4 continúa]**

**Texto a decir:**
> "En resumen, implementamos exitosamente:
> - ✅ Un API REST completa con operaciones CRUD
> - ✅ Documentación automática con OpenAPI/Swagger
> - ✅ Arquitectura basada en principios SOLID
> - ✅ Manejo robusto de errores y validaciones
> - ✅ Separación clara de responsabilidades en capas
>
> El código está completamente funcional, documentado y disponible en nuestro repositorio de GitHub.
>
> Este proyecto demuestra la aplicación práctica de buenas prácticas de desarrollo y está listo para ser extendido con nuevas funcionalidades.
>
> Gracias por su atención. ¡Hasta pronto!"

**[Mostrar en pantalla:]**
- Checklist de lo implementado (con checks animados)
- URL del repositorio GitHub
- Nombres de los integrantes del equipo

---

## 🎥 **CONSEJOS PARA LA GRABACIÓN**

### Antes de Grabar:
1. ✅ Cerrar todas las aplicaciones innecesarias
2. ✅ Configurar resolución de pantalla a 1920x1080
3. ✅ Activar modo "No molestar" (desactivar notificaciones)
4. ✅ Probar el audio de cada participante
5. ✅ Tener el proyecto corriendo y funcionando
6. ✅ Tener Swagger UI abierto en una pestaña
7. ✅ Tener VS Code abierto con el proyecto
8. ✅ Limpiar el escritorio

### Durante la Grabación:
- 🎤 Hablar claro y a ritmo pausado
- 🖱️ Movimientos de mouse suaves y deliberados
- 📍 Usar el cursor para señalar lo importante
- ⏱️ Respetar los tiempos de cada sección
- 🔄 Si se equivocan, pueden editar después

### Transiciones Entre Participantes:
```
Persona 1 → Persona 2: "Ahora, [NOMBRE] nos mostrará..."
Persona 2 → Persona 3: "Gracias [NOMBRE]. Ahora..."
Persona 3 → Persona 4: "Excelente. [NOMBRE] nos demostrará..."
```

---

## 📋 **CHECKLIST PRE-GRABACIÓN**

### Técnico:
- [ ] Aplicación corriendo en localhost:8080
- [ ] Swagger UI accesible y funcionando
- [ ] Base de datos limpia (sin datos de prueba antiguos)
- [ ] VS Code abierto con el proyecto
- [ ] Navegador con pestañas preparadas
- [ ] Micrófono funcionando
- [ ] Software de grabación probado

### Contenido:
- [ ] Cada persona conoce su parte
- [ ] Practicar transiciones
- [ ] Tiempo total no excede 5 minutos
- [ ] Datos de prueba preparados
- [ ] URLs y comandos listos para copiar

### Presentación:
- [ ] Nombres de integrantes listos para mostrar
- [ ] URL del repositorio GitHub
- [ ] Logo o título del proyecto
- [ ] Checklist de conclusiones preparada

---

## 🎨 **ELEMENTOS VISUALES RECOMENDADOS**

### Pantalla de Inicio:
```
═══════════════════════════════════════
    ROLLER SPEED ACADEMY
    Implementación de Servicios CRUD
    con Documentación OpenAPI
    
    Actividad 3 - MVC
    IU Digital 2025-02
    
    Integrantes:
    - [Nombre 1]
    - [Nombre 2]
    - [Nombre 3]
    - [Nombre 4]
═══════════════════════════════════════
```

### Pantalla de Conclusión:
```
✅ IMPLEMENTACIÓN COMPLETADA
   
   ✓ API REST CRUD
   ✓ Documentación OpenAPI/Swagger
   ✓ Principios SOLID
   ✓ Manejo de Excepciones
   ✓ Validaciones
   
   🔗 github.com/Wilgarle/Roller_speed
   
   ¡Gracias por su atención!
```

---

## ⚡ **TIPS FINALES**

1. **Ensayar antes de grabar** - Hacer al menos 1 ensayo completo
2. **Mantener energía** - Hablar con entusiasmo pero profesional
3. **Mostrar, no solo decir** - Siempre mostrar en pantalla lo que se menciona
4. **Editar si es necesario** - No tiene que ser en una sola toma
5. **Subtítulos opcionales** - Considerar agregar texto en puntos clave
6. **Música de fondo suave** - Opcional, solo en intro y outro
7. **Exportar en buena calidad** - Al menos 720p, preferible 1080p

---

## 📊 **DISTRIBUCIÓN DEL TIEMPO**

| Sección | Duración | Participante |
|---------|----------|--------------|
| Introducción | 45 seg | Persona 1 |
| Arquitectura | 1 min | Persona 1 |
| Swagger UI | 1 min | Persona 2 |
| Código SOLID | 1:15 min | Persona 3 |
| Demo en Vivo | 1:30 min | Persona 4 |
| Conclusiones | 30 seg | Persona 4 |
| **TOTAL** | **≈ 5 min** | - |

---

**¡Mucho éxito con la grabación! 🎬✨**
