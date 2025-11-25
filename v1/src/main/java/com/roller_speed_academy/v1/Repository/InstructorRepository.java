package com.roller_speed_academy.v1.Repository;

import com.roller_speed_academy.v1.Model.InstructorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad InstructorModel.
 * Aplica principio de Inversión de Dependencias (DIP): 
 * las capas superiores dependen de esta abstracción.
 */
@Repository
public interface InstructorRepository extends JpaRepository<InstructorModel, Long> {
    
    /**
     * Busca un instructor por su email
     */
    Optional<InstructorModel> findByEmail(String email);
    
    /**
     * Busca instructores por especialidad
     */
    List<InstructorModel> findByEspecialidad(String especialidad);
    
    /**
     * Busca instructores por estado
     */
    List<InstructorModel> findByEstado(String estado);
    
    /**
     * Busca instructores activos
     */
    default List<InstructorModel> findActivos() {
        return findByEstado("Activo");
    }
}
