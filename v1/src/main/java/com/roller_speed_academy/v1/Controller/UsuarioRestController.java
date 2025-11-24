package com.roller_speed_academy.v1.Controller;

import com.roller_speed_academy.v1.DTO.UsuarioDTO;
import com.roller_speed_academy.v1.DTO.UsuarioRequestDTO;
import com.roller_speed_academy.v1.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de usuarios
 * Aplica principios SOLID:
 * - SRP: Responsabilidad única de manejar peticiones HTTP de usuarios
 * - DIP: Depende de la abstracción UsuarioService
 * - OCP: Abierto para extensión mediante endpoints adicionales
 */
@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "API para la gestión de usuarios de Roller Speed Academy")
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    @Operation(
            summary = "Obtener todos los usuarios",
            description = "Retorna una lista con todos los usuarios registrados en el sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de usuarios obtenida exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content
            )
    })
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodosLosUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(
            summary = "Obtener usuario por ID",
            description = "Retorna los detalles de un usuario específico basado en su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuario encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "ID inválido",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(
            @Parameter(description = "ID del usuario a buscar", required = true, example = "1")
            @PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @Operation(
            summary = "Crear nuevo usuario",
            description = "Registra un nuevo usuario en el sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Usuario creado exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content
            )
    })
    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(
            @Parameter(description = "Datos del usuario a crear", required = true)
            @Valid @RequestBody UsuarioRequestDTO usuarioRequest) {
        UsuarioDTO nuevoUsuario = usuarioService.crearUsuario(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @Operation(
            summary = "Actualizar usuario existente",
            description = "Actualiza los datos de un usuario existente en el sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuario actualizado exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos",
                    content = @Content
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(
            @Parameter(description = "ID del usuario a actualizar", required = true, example = "1")
            @PathVariable Long id,
            @Parameter(description = "Nuevos datos del usuario", required = true)
            @Valid @RequestBody UsuarioRequestDTO usuarioRequest) {
        UsuarioDTO usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioRequest);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @Operation(
            summary = "Eliminar usuario",
            description = "Elimina un usuario del sistema de forma permanente"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Usuario eliminado exitosamente",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado",
                    content = @Content
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(
            @Parameter(description = "ID del usuario a eliminar", required = true, example = "1")
            @PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
