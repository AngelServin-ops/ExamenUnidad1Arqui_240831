/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class Taller {

    private String idTaller;
    private String nombreCurso;
    private String nombreInstructor;
    private LocalDateTime fecha;
    private int capacidad;
    private int inscritos;
    private List<String> alumnosInscritos = new ArrayList<>();

    public Taller(String idTaller, String nombreCurso, String nombreInstructor,
            LocalDateTime fecha, int capacidad) {
        this.idTaller = idTaller;
        this.nombreCurso = nombreCurso;
        this.nombreInstructor = nombreInstructor;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.inscritos = 0;
    }

    public boolean alumnoYaInscrito(String idAlumno) {
        return alumnosInscritos.contains(idAlumno);
    }

    public void inscribirAlumno(String idAlumno) {
        alumnosInscritos.add(idAlumno);
        inscritos++;
        capacidad--;
    }

    public String getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(String v) {
        this.idTaller = v;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String v) {
        this.nombreCurso = v;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public void setNombreInstructor(String v) {
        this.nombreInstructor = v;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime v) {
        this.fecha = v;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int v) {
        this.capacidad = v;
    }

    public int getInscritos() {
        return inscritos;
    }
}
