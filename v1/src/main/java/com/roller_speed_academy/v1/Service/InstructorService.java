package com.roller_speed_academy.v1.Service;

import com.roller_speed_academy.v1.Model.InstructorModel;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para operaciones de negocio relacionadas con instructores.
 * Aplica principio de Inversión de Dependencias (DIP): 
 * define contrato sin implementación concreta.
 */
public interface InstructorService {
    
    /**
     * Obtiene todos los instructores registrados
     */
    List<InstructorModel> obtenerTodosLosInstructores();
    
    /**
     * Obtiene instructores activos
     */
    List<InstructorModel> obtenerInstructoresActivos();
    
    /**
     * Obtiene un instructor por su ID
     */
    Optional<InstructorModel> obtenerInstructorPorId(Long id);
    
    /**
     * Obtiene un instructor por su email
     */
    Optional<InstructorModel> obtenerInstructorPorEmail(String email);
    
    /**
     * Obtiene instructores por especialidad
     */
    List<InstructorModel> obtenerInstructoresPorEspecialidad(String especialidad);
    
    /**
     * Registra un nuevo instructor
     */
    InstructorModel registrarInstructor(InstructorModel instructor);
    
    /**
     * Actualiza información de un instructor
     */
    InstructorModel actualizarInstructor(Long id, InstructorModel instructor);
    
    /**
     * Elimina un instructor
     */
    void eliminarInstructor(Long id);
    
    /**
     * Verifica si existe un email registrado
     */
    boolean existeEmail(String email);
}
