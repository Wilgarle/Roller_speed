package com.roller_speed_academy.v1.Service;

import com.roller_speed_academy.v1.DTO.UsuarioDTO;
import com.roller_speed_academy.v1.DTO.UsuarioRequestDTO;

import java.util.List;

/**
 * Interfaz del servicio de Usuario
 * Aplica el principio de Inversión de Dependencias (DIP) - SOLID
 * Define el contrato de operaciones CRUD para usuarios
 */
public interface UsuarioService {
    
    /**
     * Obtiene todos los usuarios del sistema
     * @return Lista de usuarios
     */
    List<UsuarioDTO> obtenerTodosLosUsuarios();
    
    /**
     * Obtiene un usuario por su ID
     * @param id Identificador del usuario
     * @return UsuarioDTO encontrado
     * @throws ResourceNotFoundException si no se encuentra el usuario
     */
    UsuarioDTO obtenerUsuarioPorId(Long id);
    
    /**
     * Crea un nuevo usuario
     * @param usuarioRequest Datos del usuario a crear
     * @return Usuario creado
     */
    UsuarioDTO crearUsuario(UsuarioRequestDTO usuarioRequest);
    
    /**
     * Actualiza un usuario existente
     * @param id Identificador del usuario a actualizar
     * @param usuarioRequest Nuevos datos del usuario
     * @return Usuario actualizado
     * @throws ResourceNotFoundException si no se encuentra el usuario
     */
    UsuarioDTO actualizarUsuario(Long id, UsuarioRequestDTO usuarioRequest);
    
    /**
     * Elimina un usuario del sistema
     * @param id Identificador del usuario a eliminar
     * @throws ResourceNotFoundException si no se encuentra el usuario
     */
    void eliminarUsuario(Long id);
}
