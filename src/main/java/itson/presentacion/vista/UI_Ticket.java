/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package itson.presentacion.vista;

import itson.entidades.DTOs.AlumnoDTO;
import itson.entidades.DTOs.TallerDTO;
import itson.presentacion.control.ControlInscripcion;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author angel
 */
public class UI_Ticket extends javax.swing.JPanel {

    private static final Color ITSON_AZUL = new Color(0, 87, 168);
    private static final Color ITSON_AZUL_PRESS = new Color(0, 60, 120);
    private static final Color BLANCO = Color.WHITE;
    private static final Color TEXTO_OSCURO = new Color(20, 20, 20);
    private static final Color BORDE_TARJETA = new Color(180, 205, 235);
    private static final Color VERDE_OK = new Color(0, 140, 70);

    private final ControlInscripcion control;
    private JPanel contenidoTicket;

    public UI_Ticket(ControlInscripcion control) {
        this.control = control;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(BLANCO);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(ITSON_AZUL, 1, true),
                new EmptyBorder(16, 22, 16, 22)));

        contenidoTicket = new JPanel();
        contenidoTicket.setLayout(new BoxLayout(contenidoTicket, BoxLayout.Y_AXIS));
        contenidoTicket.setOpaque(false);
        add(contenidoTicket);
    }

    /**
     * Llamado desde VistaInscripcion.update() cuando esExitosa() == true.
     * Rellena y muestra el ticket con los datos del alumno y taller
     * confirmados.
     */
    public void mostrarTicket(AlumnoDTO alumno, TallerDTO taller) {
        renderTicket(alumno, taller);
    }

    private void renderTicket(AlumnoDTO a, TallerDTO t) {
        contenidoTicket.removeAll();

        JLabel titulo = new JLabel("  Inscripción Confirmada", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setForeground(VERDE_OK);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep.setForeground(BORDE_TARJETA);

        JPanel grid = new JPanel(new GridLayout(0, 2, 10, 4));
        grid.setOpaque(false);
        grid.setBorder(new EmptyBorder(8, 4, 4, 4));
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);

        if (a != null) {
            fila(grid, "ID Alumno:", a.getIdAlumno());
            fila(grid, "Nombre:", a.getNombre());
            fila(grid, "Semestre:", a.getSemestre());
            fila(grid, "Programa:", a.getProgramaEducativo());
        }
        if (t != null) {
            fila(grid, "Taller:", t.getNombreCurso());
            fila(grid, "Fecha/Hora:", t.getFecha()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        }
        fila(grid, "Folio:", "ISW-" + (System.currentTimeMillis() % 99999));
        fila(grid, "Emitido:", java.time.LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        JButton btnNueva = itsonBtn("  Nueva Inscripción");
        btnNueva.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnNueva.addActionListener(e -> control.limpiarPantalla());

        contenidoTicket.add(titulo);
        contenidoTicket.add(Box.createVerticalStrut(4));
        contenidoTicket.add(sep);
        contenidoTicket.add(grid);
        contenidoTicket.add(Box.createVerticalStrut(8));
        contenidoTicket.add(btnNueva);
        contenidoTicket.revalidate();
        contenidoTicket.repaint();
    }

    private void fila(JPanel panel, String etq, String val) {
        JLabel e = new JLabel(etq);
        e.setFont(new Font("Arial", Font.BOLD, 11));
        e.setForeground(new Color(90, 90, 90));
        JLabel v = new JLabel(val);
        v.setFont(new Font("Arial", Font.PLAIN, 13));
        v.setForeground(TEXTO_OSCURO);
        panel.add(e);
        panel.add(v);
    }

    private JButton itsonBtn(String txt) {
        JButton btn = new JButton(txt) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(isEnabled() ? (getModel().isPressed() ? ITSON_AZUL_PRESS : ITSON_AZUL) : new Color(160, 160, 160));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("Arial", Font.BOLD, 11));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(new EmptyBorder(6, 16, 6, 16));
        return btn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
