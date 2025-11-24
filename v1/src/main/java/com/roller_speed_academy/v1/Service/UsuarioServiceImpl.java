package com.roller_speed_academy.v1.Service;

import com.roller_speed_academy.v1.DTO.UsuarioDTO;
import com.roller_speed_academy.v1.DTO.UsuarioRequestDTO;
import com.roller_speed_academy.v1.Exception.ResourceNotFoundException;
import com.roller_speed_academy.v1.Model.UsuarioModel;
import com.roller_speed_academy.v1.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de Usuario
 * Aplica principios SOLID:
 * - SRP: Responsabilidad única de gestionar la lógica de negocio de usuarios
 * - OCP: Abierto para extensión (heredable), cerrado para modificación
 * - DIP: Depende de abstracciones (UsuarioRepository interface)
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        log.info("Obteniendo todos los usuarios");
        return usuarioRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        log.info("Buscando usuario con ID: {}", id);
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuario no encontrado con ID: " + id));
        return convertirADTO(usuario);
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioRequestDTO usuarioRequest) {
        log.info("Creando nuevo usuario: {}", usuarioRequest.getNombreUsuario());
        
        UsuarioModel nuevoUsuario = new UsuarioModel();
        nuevoUsuario.setNombreUsuario(usuarioRequest.getNombreUsuario());
        nuevoUsuario.setContrasena(usuarioRequest.getContrasena());
        
        UsuarioModel usuarioGuardado = usuarioRepository.save(nuevoUsuario);
        log.info("Usuario creado exitosamente con ID: {}", usuarioGuardado.getIdUsuario());
        
        return convertirADTO(usuarioGuardado);
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long id, UsuarioRequestDTO usuarioRequest) {
        log.info("Actualizando usuario con ID: {}", id);
        
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuario no encontrado con ID: " + id));
        
        usuarioExistente.setNombreUsuario(usuarioRequest.getNombreUsuario());
        usuarioExistente.setContrasena(usuarioRequest.getContrasena());
        
        UsuarioModel usuarioActualizado = usuarioRepository.save(usuarioExistente);
        log.info("Usuario actualizado exitosamente: {}", usuarioActualizado.getIdUsuario());
        
        return convertirADTO(usuarioActualizado);
    }

    @Override
    public void eliminarUsuario(Long id) {
        log.info("Eliminando usuario con ID: {}", id);
        
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
        }
        
        usuarioRepository.deleteById(id);
        log.info("Usuario eliminado exitosamente: {}", id);
    }

    /**
     * Método privado para convertir UsuarioModel a UsuarioDTO
     * Aplica el principio SRP - responsabilidad única de conversión
     */
    private UsuarioDTO convertirADTO(UsuarioModel usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        // No exponemos la contraseña en las respuestas por seguridad
        return dto;
    }
}
