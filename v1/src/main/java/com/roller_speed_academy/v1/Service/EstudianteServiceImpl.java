package com.roller_speed_academy.v1.Service;

import com.roller_speed_academy.v1.Model.EstudianteModel;
import com.roller_speed_academy.v1.Repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de estudiantes.
 * Aplica principios SOLID:
 * - SRP: Solo maneja lógica de negocio de estudiantes
 * - OCP: Abierto a extensión mediante la interfaz EstudianteService
 * - DIP: Depende de abstracciones (EstudianteRepository)
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteModel> obtenerTodosLosEstudiantes() {
        log.info("Obteniendo todos los estudiantes");
        return estudianteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteModel> obtenerEstudiantesActivos() {
        log.info("Obteniendo estudiantes activos");
        return estudianteRepository.findActivos();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EstudianteModel> obtenerEstudiantePorId(Long id) {
        log.info("Obteniendo estudiante con ID: {}", id);
        return estudianteRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EstudianteModel> obtenerEstudiantePorEmail(String email) {
        log.info("Obteniendo estudiante con email: {}", email);
        return estudianteRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteModel> obtenerEstudiantesPorNivel(String nivel) {
        log.info("Obteniendo estudiantes de nivel: {}", nivel);
        return estudianteRepository.findByNivel(nivel);
    }

    @Override
    public EstudianteModel registrarEstudiante(EstudianteModel estudiante) {
        log.info("Registrando nuevo estudiante: {} {}", estudiante.getNombre(), estudiante.getApellido());
        
        if (existeEmail(estudiante.getEmail())) {
            throw new RuntimeException("El email ya está registrado: " + estudiante.getEmail());
        }
        
        return estudianteRepository.save(estudiante);
    }

    @Override
    public EstudianteModel actualizarEstudiante(Long id, EstudianteModel estudiante) {
        log.info("Actualizando estudiante con ID: {}", id);
        
        EstudianteModel estudianteExistente = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
        
        // Validar email único si se está cambiando
        if (!estudianteExistente.getEmail().equals(estudiante.getEmail()) && 
            existeEmail(estudiante.getEmail())) {
            throw new RuntimeException("El email ya está registrado: " + estudiante.getEmail());
        }
        
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        estudianteExistente.setTelefono(estudiante.getTelefono());
        estudianteExistente.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteExistente.setNivel(estudiante.getNivel());
        estudianteExistente.setEstado(estudiante.getEstado());
        
        return estudianteRepository.save(estudianteExistente);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        log.info("Eliminando estudiante con ID: {}", id);
        
        if (!estudianteRepository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado con ID: " + id);
        }
        
        estudianteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeEmail(String email) {
        return estudianteRepository.findByEmail(email).isPresent();
    }
}
