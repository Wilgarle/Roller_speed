package com.roller_speed_academy.v1.Service;

import com.roller_speed_academy.v1.Model.InstructorModel;
import com.roller_speed_academy.v1.Repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de instructores.
 * Aplica principios SOLID:
 * - SRP: Solo maneja lógica de negocio de instructores
 * - OCP: Abierto a extensión mediante la interfaz InstructorService
 * - DIP: Depende de abstracciones (InstructorRepository)
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<InstructorModel> obtenerTodosLosInstructores() {
        log.info("Obteniendo todos los instructores");
        return instructorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstructorModel> obtenerInstructoresActivos() {
        log.info("Obteniendo instructores activos");
        return instructorRepository.findActivos();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InstructorModel> obtenerInstructorPorId(Long id) {
        log.info("Obteniendo instructor con ID: {}", id);
        return instructorRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InstructorModel> obtenerInstructorPorEmail(String email) {
        log.info("Obteniendo instructor con email: {}", email);
        return instructorRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstructorModel> obtenerInstructoresPorEspecialidad(String especialidad) {
        log.info("Obteniendo instructores de especialidad: {}", especialidad);
        return instructorRepository.findByEspecialidad(especialidad);
    }

    @Override
    public InstructorModel registrarInstructor(InstructorModel instructor) {
        log.info("Registrando nuevo instructor: {} {}", instructor.getNombre(), instructor.getApellido());
        
        if (existeEmail(instructor.getEmail())) {
            throw new RuntimeException("El email ya está registrado: " + instructor.getEmail());
        }
        
        return instructorRepository.save(instructor);
    }

    @Override
    public InstructorModel actualizarInstructor(Long id, InstructorModel instructor) {
        log.info("Actualizando instructor con ID: {}", id);
        
        InstructorModel instructorExistente = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor no encontrado con ID: " + id));
        
        // Validar email único si se está cambiando
        if (!instructorExistente.getEmail().equals(instructor.getEmail()) && 
            existeEmail(instructor.getEmail())) {
            throw new RuntimeException("El email ya está registrado: " + instructor.getEmail());
        }
        
        instructorExistente.setNombre(instructor.getNombre());
        instructorExistente.setApellido(instructor.getApellido());
        instructorExistente.setEmail(instructor.getEmail());
        instructorExistente.setTelefono(instructor.getTelefono());
        instructorExistente.setEspecialidad(instructor.getEspecialidad());
        instructorExistente.setCertificaciones(instructor.getCertificaciones());
        instructorExistente.setExperienciaAnos(instructor.getExperienciaAnos());
        instructorExistente.setEstado(instructor.getEstado());
        
        return instructorRepository.save(instructorExistente);
    }

    @Override
    public void eliminarInstructor(Long id) {
        log.info("Eliminando instructor con ID: {}", id);
        
        if (!instructorRepository.existsById(id)) {
            throw new RuntimeException("Instructor no encontrado con ID: " + id);
        }
        
        instructorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeEmail(String email) {
        return instructorRepository.findByEmail(email).isPresent();
    }
}
