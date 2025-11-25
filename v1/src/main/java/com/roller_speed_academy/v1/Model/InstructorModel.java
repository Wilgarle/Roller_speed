package com.roller_speed_academy.v1.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entidad que representa un instructor en la academia Roller Speed.
 * Aplica principio de Responsabilidad Única (SRP): solo maneja datos de instructores.
 */
@Entity
@Table(name = "tbl_instructores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instructor")
    private Long idInstructor;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", unique = true, nullable = false, length = 150)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "especialidad", length = 100)
    private String especialidad; // Hockey, Artístico, Velocidad, etc.

    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;

    @Column(name = "certificaciones", length = 500)
    private String certificaciones;

    @Column(name = "estado", length = 20)
    private String estado; // Activo, Inactivo, Licencia

    @Column(name = "experiencia_anos")
    private Integer experienciaAnos;

    @Column(name = "clase_asignada", length = 100)
    private String claseAsignada; // Grupo al que está asignado el instructor

    @Column(name = "dia_semana", length = 20)
    private String diaSemana; // Día de la semana de la clase

    @Column(name = "horario", length = 20)
    private String horario; // Horario de la clase

    @PrePersist
    protected void onCreate() {
        fechaContratacion = LocalDate.now();
        if (estado == null) {
            estado = "Activo";
        }
    }
}
