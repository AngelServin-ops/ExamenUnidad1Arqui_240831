/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.entidades.fachada;

import itson.entidades.DTOs.AlumnoDTO;
import itson.entidades.DTOs.TallerDTO;
import itson.entidades.Taller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author angel
 */
public class Dominio implements IDominio {

    private List<Taller> talleres = Arrays.asList(
            new Taller("1", "Arquitectura de Microservicios", "Gilberto Borrego Soto", LocalDateTime.of(2026, 10, 25, 9, 0), 20),
            new Taller("2", "Despliegue con Docker y Kubernetes", "Gilberto Borrego Soto", LocalDateTime.of(2026, 10, 25, 12, 30), 15),
            new Taller("3", "Seguridad en Aplicaciones Web", "Gilberto Borrego Soto", LocalDateTime.of(2026, 10, 26, 16, 0), 30),
            new Taller("4", "Desarrollo de APIs REST con Spring Boot", "Gilberto Borrego Soto", LocalDateTime.of(2026, 10, 26, 10, 0), 15),
            new Taller("5", "Inteligencia Artificial con Python", "Laura Medina Cisneros", LocalDateTime.of(2026, 10, 27, 9, 0), 25),
            new Taller("6", "Desarrollo Mobile con Flutter", "Ernesto Ibarra Fuentes", LocalDateTime.of(2026, 10, 27, 11, 0), 20),
            new Taller("7", "DevOps y CI/CD con GitHub Actions", "Carlos Pérez Meza", LocalDateTime.of(2026, 10, 27, 14, 0), 18),
            new Taller("8", "Bases de Datos NoSQL con MongoDB", "Valeria Montoya Ibarra", LocalDateTime.of(2026, 10, 28, 9, 0), 22),
            new Taller("9", "Cloud Computing con AWS", "Diego Ruiz Torres", LocalDateTime.of(2026, 10, 28, 13, 0), 20),
            new Taller("10", "Pruebas de Software y QA Automation", "Sofía Castillo Vega", LocalDateTime.of(2026, 10, 28, 16, 0), 25)
    );

    private List<AlumnoDTO> alumnosMock = Arrays.asList(
            new AlumnoDTO("240831", "Angel Servin de la Mora", "6to Semestre", "ISW"),
            new AlumnoDTO("240112", "Maria Fernanda Lopez Ruiz", "4to Semestre", "ISW"),
            new AlumnoDTO("239874", "Carlos Eduardo Pérez Meza", "8vo Semestre", "ISW"),
            new AlumnoDTO("241005", "Valeria Montoya Ibarra", "2do Semestre", "ISW"),
            new AlumnoDTO("238650", "Diego Armando Ruiz Torres", "6to Semestre", "ISW"),
            new AlumnoDTO("240567", "Sofía Alejandra Castillo Vega", "4to Semestre", "ISW"),
            new AlumnoDTO("237891", "Luis Ernesto Soto Carrillo", "8vo Semestre", "ISW"),
            new AlumnoDTO("241230", "Paola Itzel Moreno Ríos", "2do Semestre", "ISW"),
            new AlumnoDTO("242001", "Ricardo Javier Flores Medina", "4to Semestre", "ISW"),
            new AlumnoDTO("242002", "Ana Lucía Herrera Campos", "6to Semestre", "ISW"),
            new AlumnoDTO("242003", "Jorge Iván Contreras Salinas", "2do Semestre", "ISW"),
            new AlumnoDTO("242004", "Daniela Valentina Ortiz Peña", "8vo Semestre", "ISW"),
            new AlumnoDTO("242005", "Héctor Manuel Vázquez Luna", "4to Semestre", "ISW"),
            new AlumnoDTO("242006", "Gabriela Isabel Ramos Espinoza", "6to Semestre", "ISW"),
            new AlumnoDTO("242007", "Fernando Alexis Núñez Mora", "2do Semestre", "ISW"),
            new AlumnoDTO("242008", "Claudia Patricia Mendoza Ávila", "8vo Semestre", "ISW"),
            new AlumnoDTO("242009", "Roberto Carlos Aguilar Reyes", "4to Semestre", "ISW"),
            new AlumnoDTO("242010", "Ximena Guadalupe Torres Sandoval", "6to Semestre", "ISW"),
            new AlumnoDTO("242011", "Andrés Felipe Gutiérrez Leal", "2do Semestre", "ISW"),
            new AlumnoDTO("242012", "Mariana Sofía Delgado Cisneros", "8vo Semestre", "ISW"),
            new AlumnoDTO("242013", "Pablo Emilio Cervantes Quiroz", "4to Semestre", "ISW"),
            new AlumnoDTO("242014", "Laura Beatriz Pacheco Villanueva", "6to Semestre", "ISW"),
            new AlumnoDTO("242015", "Ernesto Guillermo Ibarra Fuentes", "2do Semestre", "ISW")
    );

    public Dominio() {
        precargarInscripciones();
    }

    private void precargarInscripciones() {
        inscribirSilencioso("240112", "1");
        inscribirSilencioso("239874", "1");
        inscribirSilencioso("241005", "1");
        inscribirSilencioso("238650", "1");
        inscribirSilencioso("240567", "1");
        inscribirSilencioso("240112", "2");
        inscribirSilencioso("239874", "2");
        inscribirSilencioso("241005", "2");
        inscribirSilencioso("238650", "2");
        inscribirSilencioso("240567", "2");
        inscribirSilencioso("237891", "2");
        inscribirSilencioso("241230", "2");
        inscribirSilencioso("240831", "2");
        inscribirSilencioso("237891", "3");
        inscribirSilencioso("241230", "3");
        inscribirSilencioso("238650", "3");
        inscribirSilencioso("242001", "4");
        inscribirSilencioso("242002", "4");
        inscribirSilencioso("242003", "4");
        inscribirSilencioso("242004", "4");
        inscribirSilencioso("242005", "4");
        inscribirSilencioso("242006", "4");
        inscribirSilencioso("242007", "4");
        inscribirSilencioso("242008", "4");
        inscribirSilencioso("242009", "4");
        inscribirSilencioso("242010", "4");
        inscribirSilencioso("242011", "4");
        inscribirSilencioso("242012", "4");
        inscribirSilencioso("242013", "4");
        inscribirSilencioso("242014", "4");
        inscribirSilencioso("242015", "4");
        inscribirSilencioso("242001", "5");
        inscribirSilencioso("242002", "5");
        inscribirSilencioso("242003", "5");
        inscribirSilencioso("240112", "5");
        inscribirSilencioso("239874", "5");
        inscribirSilencioso("241005", "5");
        inscribirSilencioso("242004", "6");
        inscribirSilencioso("242005", "6");
        inscribirSilencioso("242006", "6");
        inscribirSilencioso("242007", "6");
        inscribirSilencioso("242008", "7");
        inscribirSilencioso("242009", "7");
        inscribirSilencioso("242010", "7");
        inscribirSilencioso("242011", "7");
        inscribirSilencioso("242012", "7");
        inscribirSilencioso("242013", "7");
        inscribirSilencioso("242014", "7");
        inscribirSilencioso("242015", "7");
        inscribirSilencioso("240112", "7");
        inscribirSilencioso("239874", "7");
        inscribirSilencioso("241005", "8");
        inscribirSilencioso("238650", "8");
        inscribirSilencioso("240567", "9");
        inscribirSilencioso("237891", "9");
        inscribirSilencioso("241230", "9");
        inscribirSilencioso("242001", "9");
        inscribirSilencioso("242002", "9");
        inscribirSilencioso("242003", "9");
        inscribirSilencioso("242004", "9");
    }

    private void inscribirSilencioso(String idAlumno, String idTaller) {
        Taller t = buscarTaller(idTaller);
        if (t != null) {
            t.inscribirAlumno(idAlumno);
        }
    }

    @Override
    public List<TallerDTO> obtenerTalleresDisponibles() {
        List<TallerDTO> lista = new ArrayList<>();
        for (Taller t : talleres) {
            lista.add(new TallerDTO(t.getIdTaller(), t.getNombreCurso(), t.getNombreInstructor(),
                    t.getFecha(), t.getCapacidad(), t.getInscritos()));
        }
        return lista;
    }

    @Override
    public AlumnoDTO consultarAlumnoPorId(String idAlumno) {
        for (AlumnoDTO a : alumnosMock) {
            if (a.getIdAlumno().equals(idAlumno)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void inscribirAlumno(String idAlumno, String idTaller) {
        Taller taller = buscarTaller(idTaller);
        if (taller == null) {
            throw new IllegalArgumentException("El taller no existe.");
        }
        if (taller.alumnoYaInscrito(idAlumno)) {
            throw new IllegalStateException("El alumno ya está inscrito en \"" + taller.getNombreCurso() + "\".");
        }
        if (taller.getCapacidad() <= 0) {
            throw new IllegalStateException("No hay cupo disponible en \"" + taller.getNombreCurso() + "\".");
        }
        taller.inscribirAlumno(idAlumno);
    }

    private Taller buscarTaller(String idTaller) {
        for (Taller t : talleres) {
            if (t.getIdTaller().equals(idTaller)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean alumnoYaInscrito(String idAlumno, String idTaller) {

        Taller taller = buscarTaller(idTaller);

        if (taller == null) {
            return false;
        }

        return taller.alumnoYaInscrito(idAlumno);

    }
}
