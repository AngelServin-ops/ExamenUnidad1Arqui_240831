/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.principal;

import itson.entidades.DTOs.TallerDTO;
import itson.entidades.fachada.Dominio;
import itson.entidades.fachada.IDominio;
import itson.presentacion.control.ControlInscripcion;
import itson.presentacion.modelo.Modelo;
import itson.presentacion.vista.VistaInscripcion;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author angel
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IDominio dominio = new Dominio();
            Modelo modelo = new Modelo(dominio);
            ControlInscripcion control = new ControlInscripcion(modelo);
            new VistaInscripcion(control, modelo);

            modelo.notifyObservers();
        });
    }
}
