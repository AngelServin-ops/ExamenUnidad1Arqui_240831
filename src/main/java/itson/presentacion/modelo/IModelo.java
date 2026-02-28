/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.presentacion.modelo;

import itson.entidades.DTOs.AlumnoDTO;
import itson.entidades.DTOs.TallerDTO;
import java.util.List;

/**
 *
 * @author angel
 */
public interface IModelo {

    void seleccionarTaller(String idTaller);
    void buscarAlumno(String idAlumno);
    void confirmarInscripcion(String idAlumno, String idTaller);
    void limpiarEstado();

    AlumnoDTO getAlumno();
    TallerDTO getTallerSeleccionado();
    List<TallerDTO> getListaTalleres();
    String getMensaje();
    boolean hayAlumno();
    boolean hayTaller();
    boolean esExitosa();
    boolean alumnoYaInscrito();

}

