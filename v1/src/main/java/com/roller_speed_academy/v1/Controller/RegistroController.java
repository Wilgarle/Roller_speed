package com.roller_speed_academy.v1.Controller;

import com.roller_speed_academy.v1.Model.EstudianteModel;
import com.roller_speed_academy.v1.Model.InstructorModel;
import com.roller_speed_academy.v1.Service.EstudianteService;
import com.roller_speed_academy.v1.Service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador para las vistas de registro de estudiantes e instructores.
 * Aplica principio de Responsabilidad Única (SRP): 
 * solo maneja las vistas de registro.
 */
@Controller
@RequestMapping("/registro")
@RequiredArgsConstructor
@Slf4j
public class RegistroController {

    private final EstudianteService estudianteService;
    private final InstructorService instructorService;

    /**
     * Muestra el formulario de inscripción de estudiantes
     */
    @GetMapping("/estudiante")
    public String mostrarFormularioEstudiante(Model model) {
        log.info("Mostrando formulario de inscripción de estudiante");
        model.addAttribute("estudiante", new EstudianteModel());
        return "registro/estudiante";
    }

    /**
     * Procesa el registro de un nuevo estudiante
     */
    @PostMapping("/estudiante")
    public String registrarEstudiante(@ModelAttribute EstudianteModel estudiante, 
                                     RedirectAttributes redirectAttributes) {
        try {
            log.info("Procesando registro de estudiante: {}", estudiante.getEmail());
            estudianteService.registrarEstudiante(estudiante);
            redirectAttributes.addFlashAttribute("mensaje", "Estudiante registrado exitosamente");
            redirectAttributes.addFlashAttribute("tipo", "success");
            return "redirect:/registro/estudiante";
        } catch (Exception e) {
            log.error("Error al registrar estudiante", e);
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "error");
            return "redirect:/registro/estudiante";
        }
    }

    /**
     * Muestra el formulario de inscripción de instructores
     */
    @GetMapping("/instructor")
    public String mostrarFormularioInstructor(Model model) {
        log.info("Mostrando formulario de inscripción de instructor");
        model.addAttribute("instructor", new InstructorModel());
        return "registro/instructor";
    }

    /**
     * Procesa el registro de un nuevo instructor
     */
    @PostMapping("/instructor")
    public String registrarInstructor(@ModelAttribute InstructorModel instructor, 
                                     RedirectAttributes redirectAttributes) {
        try {
            log.info("Procesando registro de instructor: {}", instructor.getEmail());
            instructorService.registrarInstructor(instructor);
            redirectAttributes.addFlashAttribute("mensaje", "Instructor registrado exitosamente");
            redirectAttributes.addFlashAttribute("tipo", "success");
            return "redirect:/registro/instructor";
        } catch (Exception e) {
            log.error("Error al registrar instructor", e);
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "error");
            return "redirect:/registro/instructor";
        }
    }
}
