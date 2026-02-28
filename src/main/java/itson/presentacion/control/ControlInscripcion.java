/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.presentacion.control;

import itson.entidades.DTOs.AlumnoDTO;
import itson.entidades.DTOs.TallerDTO;
import itson.presentacion.modelo.IModelo;
import java.util.List;

/**
 *
 * @author angel
 */
public class ControlInscripcion {

    private final IModelo modelo;

    public ControlInscripcion(IModelo modelo) {
        this.modelo = modelo;
    }

    // Acciones
    public void seleccionarTaller(String tallerId) {
        modelo.seleccionarTaller(tallerId);
    }

    public void buscarAlumno(String alumnoId) {
        modelo.buscarAlumno(alumnoId);
    }

    public void confirmarInscripcion(String alumnoId, String tallerId) {
        modelo.confirmarInscripcion(alumnoId, tallerId);
    }

    public void limpiarPantalla() {
        modelo.limpiarEstado();
    }

    // Consultas delegadas al modelo
    public AlumnoDTO getAlumno() {
        return modelo.getAlumno();
    }

    public TallerDTO getTallerSeleccionado() {
        return modelo.getTallerSeleccionado();
    }

    public List<TallerDTO> getListaTalleres() {
        return modelo.getListaTalleres();
    }

    public String getMensaje() {
        return modelo.getMensaje();
    }

    public boolean hayAlumno() {
        return modelo.hayAlumno();
    }

    public boolean hayTaller() {
        return modelo.hayTaller();
    }

    public boolean esExitosa() {
        return modelo.esExitosa();
    }

    public boolean alumnoYaInscrito() {
        return modelo.alumnoYaInscrito();
    }

}
