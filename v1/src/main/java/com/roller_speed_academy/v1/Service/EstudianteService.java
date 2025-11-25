package com.roller_speed_academy.v1.Service;

import com.roller_speed_academy.v1.Model.EstudianteModel;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para operaciones de negocio relacionadas con estudiantes.
 * Aplica principio de Inversión de Dependencias (DIP): 
 * define contrato sin implementación concreta.
 */
public interface EstudianteService {
    
    /**
     * Obtiene todos los estudiantes registrados
     */
    List<EstudianteModel> obtenerTodosLosEstudiantes();
    
    /**
     * Obtiene estudiantes activos
     */
    List<EstudianteModel> obtenerEstudiantesActivos();
    
    /**
     * Obtiene un estudiante por su ID
     */
    Optional<EstudianteModel> obtenerEstudiantePorId(Long id);
    
    /**
     * Obtiene un estudiante por su email
     */
    Optional<EstudianteModel> obtenerEstudiantePorEmail(String email);
    
    /**
     * Obtiene estudiantes por nivel
     */
    List<EstudianteModel> obtenerEstudiantesPorNivel(String nivel);
    
    /**
     * Registra un nuevo estudiante
     */
    EstudianteModel registrarEstudiante(EstudianteModel estudiante);
    
    /**
     * Actualiza información de un estudiante
     */
    EstudianteModel actualizarEstudiante(Long id, EstudianteModel estudiante);
    
    /**
     * Elimina un estudiante
     */
    void eliminarEstudiante(Long id);
    
    /**
     * Verifica si existe un email registrado
     */
    boolean existeEmail(String email);
}
