package com.roller_speed_academy.v1.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para la respuesta de Usuario
 * Aplica el principio de Segregación de Interfaces (ISP) - SOLID
 * Separa los datos de respuesta del modelo de persistencia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Objeto de respuesta que representa un usuario del sistema")
public class UsuarioDTO {
    
    @Schema(description = "Identificador único del usuario", example = "1")
    private Long idUsuario;
    
    @Schema(description = "Nombre de usuario", example = "juan.perez")
    private String nombreUsuario;
    
    @Schema(description = "Contraseña del usuario (solo en respuesta de creación)", 
            example = "******", accessMode = Schema.AccessMode.WRITE_ONLY)
    private String contrasena;
}
