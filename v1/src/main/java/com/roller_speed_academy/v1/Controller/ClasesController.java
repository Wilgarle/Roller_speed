package com.roller_speed_academy.v1.Controller;

import com.roller_speed_academy.v1.Service.EstudianteService;
import com.roller_speed_academy.v1.Service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para las vistas relacionadas con clases, horarios y listados.
 * Aplica principio de Responsabilidad Única (SRP): 
 * solo maneja las vistas de clases y horarios.
 */
@Controller
@RequestMapping("/clases")
@RequiredArgsConstructor
@Slf4j
public class ClasesController {

    private final EstudianteService estudianteService;
    private final InstructorService instructorService;

    /**
     * Muestra la lista de estudiantes registrados
     */
    @GetMapping("/estudiantes")
    public String listarEstudiantes(Model model) {
        log.info("Mostrando lista de estudiantes");
        model.addAttribute("estudiantes", estudianteService.obtenerTodosLosEstudiantes());
        model.addAttribute("titulo", "Listado de Estudiantes");
        return "clases/lista-estudiantes";
    }

    /**
     * Muestra el horario de clases para estudiantes
     */
    @GetMapping("/horario/estudiantes")
    public String horarioEstudiantes(Model model) {
        log.info("Mostrando horario de clases para estudiantes");
        model.addAttribute("titulo", "Horario de Clases - Estudiantes");
        model.addAttribute("tipoUsuario", "estudiante");
        return "clases/horario";
    }

    /**
     * Muestra el horario de clases para instructores
     */
    @GetMapping("/horario/instructores")
    public String horarioInstructores(Model model) {
        log.info("Mostrando horario de clases para instructores");
        model.addAttribute("titulo", "Horario de Clases - Instructores");
        model.addAttribute("instructores", instructorService.obtenerInstructoresActivos());
        model.addAttribute("todosInstructores", instructorService.obtenerTodosLosInstructores());
        model.addAttribute("tipoUsuario", "instructor");
        return "clases/horario";
    }
}
