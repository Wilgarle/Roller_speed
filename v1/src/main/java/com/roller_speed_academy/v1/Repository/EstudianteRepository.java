package com.roller_speed_academy.v1.Repository;

import com.roller_speed_academy.v1.Model.EstudianteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad EstudianteModel.
 * Aplica principio de Inversión de Dependencias (DIP): 
 * las capas superiores dependen de esta abstracción.
 */
@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteModel, Long> {
    
    /**
     * Busca un estudiante por su email
     */
    Optional<EstudianteModel> findByEmail(String email);
    
    /**
     * Busca estudiantes por nivel
     */
    List<EstudianteModel> findByNivel(String nivel);
    
    /**
     * Busca estudiantes por estado
     */
    List<EstudianteModel> findByEstado(String estado);
    
    /**
     * Busca estudiantes activos
     */
    default List<EstudianteModel> findActivos() {
        return findByEstado("Activo");
    }
}
