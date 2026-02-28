/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.presentacion.modelo;

import itson.entidades.DTOs.AlumnoDTO;
import itson.entidades.DTOs.TallerDTO;
import itson.entidades.fachada.IDominio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class Modelo implements IModelo, ISubject {

    private final IDominio dominio;
    private TallerDTO tallerSeleccionado;
    private AlumnoDTO alumnoSeleccionado;
    private String mensaje;
    private boolean exitosa;
    private boolean alumnoYaInscrito;
    private final List<IObserver> observers = new ArrayList<>();

    public Modelo(IDominio dominio) {
        this.dominio = dominio;
    }

    @Override
    public void seleccionarTaller(String idTaller) {
        tallerSeleccionado = dominio.obtenerTalleresDisponibles().stream()
                .filter(t -> t.getIdTaller().equals(idTaller))
                .findFirst().orElse(null);
        alumnoSeleccionado = null;
        mensaje = null;
        exitosa = false;
        notifyObservers();
    }

    @Override
    public void buscarAlumno(String idAlumno) {
        alumnoSeleccionado = dominio.consultarAlumnoPorId(idAlumno);
        mensaje = (alumnoSeleccionado == null) ? "Alumno no encontrado." : null;
        exitosa = false;
        notifyObservers();
    }

    @Override
    public void confirmarInscripcion(String idAlumno, String idTaller) {
        try {
            dominio.inscribirAlumno(idAlumno, idTaller);
            mensaje = "Inscripción confirmada exitosamente";
            exitosa = true;
            tallerSeleccionado = dominio.obtenerTalleresDisponibles().stream()
                    .filter(t -> t.getIdTaller().equals(idTaller))
                    .findFirst().orElse(tallerSeleccionado);
        } catch (Exception e) {
            mensaje = e.getMessage();
            exitosa = false;
        }
        notifyObservers();
    }

    @Override
    public void limpiarEstado() {
        tallerSeleccionado = null;
        alumnoSeleccionado = null;
        mensaje = null;
        exitosa = false;
        notifyObservers();
    }

    @Override
    public AlumnoDTO getAlumno() {
        return alumnoSeleccionado;
    }

    @Override
    public TallerDTO getTallerSeleccionado() {
        return tallerSeleccionado;
    }

    @Override
    public List<TallerDTO> getListaTalleres() {
        return dominio.obtenerTalleresDisponibles();
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean hayAlumno() {
        return alumnoSeleccionado != null;
    }

    @Override
    public boolean hayTaller() {
        return tallerSeleccionado != null;
    }

    @Override
    public boolean esExitosa() {
        return exitosa;
    }

    @Override
    public void addObserver(IObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update();
        }
    }

    @Override
    public boolean alumnoYaInscrito() {
        return alumnoYaInscrito;
    }
}
