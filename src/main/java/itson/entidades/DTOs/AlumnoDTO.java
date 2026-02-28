/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.entidades.DTOs;

/**
 *
 * @author angel
 */
public class AlumnoDTO {

    private final String idAlumno;
    private final String nombre;
    private final String semestre;
    private final String programaEducativo;

    public AlumnoDTO(String idAlumno, String nombre, String semestre, String programaEducativo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.semestre = semestre;
        this.programaEducativo = programaEducativo;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

}
