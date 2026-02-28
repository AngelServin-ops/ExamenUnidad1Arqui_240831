/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.entidades.fachada;

import itson.entidades.DTOs.AlumnoDTO;
import itson.entidades.DTOs.TallerDTO;
import java.util.List;

/**
 *
 * @author angel
 */
public interface IDominio {

    List<TallerDTO> obtenerTalleresDisponibles();

    AlumnoDTO consultarAlumnoPorId(String idAlumno);

    void inscribirAlumno(String idAlumno, String idTaller);
    
    boolean alumnoYaInscrito(String idAlumno, String idTaller);

}
