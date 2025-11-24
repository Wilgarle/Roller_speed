package com.roller_speed_academy.v1.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para la creación y actualización de usuarios
 * Aplica validaciones y separa la entrada de datos del modelo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Objeto de solicitud para crear o actualizar un usuario")
public class UsuarioRequestDTO {
    
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre de usuario debe tener entre 3 y 50 caracteres")
    @Schema(description = "Nombre de usuario", example = "juan.perez", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombreUsuario;
    
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 100, message = "La contraseña debe tener al menos 6 caracteres")
    @Schema(description = "Contraseña del usuario", example = "Password123!", requiredMode = Schema.RequiredMode.REQUIRED)
    private String contrasena;
}
