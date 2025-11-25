package com.roller_speed_academy.v1.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entidad que representa un estudiante en la academia Roller Speed.
 * Aplica principio de Responsabilidad Única (SRP): solo maneja datos de estudiantes.
 */
@Entity
@Table(name = "tbl_estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", unique = true, nullable = false, length = 150)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "nivel", length = 50)
    private String nivel; // Principiante, Intermedio, Avanzado

    @Column(name = "estado", length = 20)
    private String estado; // Activo, Inactivo, Suspendido

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDate.now();
        if (estado == null) {
            estado = "Activo";
        }
        if (nivel == null) {
            nivel = "Principiante";
        }
    }
}
