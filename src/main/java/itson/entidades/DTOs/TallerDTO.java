/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.entidades.DTOs;

import java.time.LocalDateTime;

/**
 *
 * @author angel
 */
public class TallerDTO {

    private final String idTaller;
    private final String nombreCurso;
    private final String nombreInstructor;
    private final LocalDateTime fecha;
    private final int capacidad;
    private final int inscritos;

    public TallerDTO(String idTaller, String nombreCurso, String nombreInstructor,
            LocalDateTime fecha, int capacidad, int inscritos) {
        this.idTaller = idTaller;
        this.nombreCurso = nombreCurso;
        this.nombreInstructor = nombreInstructor;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.inscritos = inscritos;
    }

    public String getIdTaller() {
        return idTaller;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getInscritos() {
        return inscritos;
    }

    public boolean tieneLugar() {
        return capacidad > 0;
    }
}
