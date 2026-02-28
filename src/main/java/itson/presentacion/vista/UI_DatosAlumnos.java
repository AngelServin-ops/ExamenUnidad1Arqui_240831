/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package itson.presentacion.vista;

import itson.entidades.DTOs.AlumnoDTO;
import itson.presentacion.control.ControlInscripcion;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *
 * @author angel
 */
public class UI_DatosAlumnos extends javax.swing.JPanel {

    private static final Color ITSON_AZUL = new Color(0, 87, 168);
    private static final Color ITSON_AZUL_PRESS = new Color(0, 60, 120);
    private static final Color BLANCO = Color.WHITE;
    private static final Color TEXTO_OSCURO = new Color(20, 20, 20);
    private static final Color BORDE_TARJETA = new Color(180, 205, 235);
    private static final Color ROJO_CERRAR = new Color(200, 40, 40);
    private static final Color ROJO_CERRAR_PRESS = new Color(160, 20, 20);

    private final ControlInscripcion control;
    private Runnable onCerrarClick;

    private String tallerIdActual;
    private JTextField campoId;
    private JButton btnBuscar, btnConfirmar, btnCerrar;
    private JLabel lblMensaje;
    private JLabel lblNombre, lblIdAlumno, lblSemestre, lblPrograma;

    public UI_DatosAlumnos(ControlInscripcion control) {
        this.control = control;
        initUI();
    }

    public void setTallerIdActual(String tallerId) {
        this.tallerIdActual = tallerId;
    }

    public void setOnCerrarClick(Runnable callback) {
        this.onCerrarClick = callback;
    }

    /**
     * Limpia el panel y pone el foco en el campo ID.
     */
    public void mostrar() {
        resetear();
        campoId.requestFocus();
    }

    /**
     * Rellena los datos del alumno encontrado.
     */
    public void mostrarAlumno(AlumnoDTO alumno) {
        lblMensaje.setText(" ");
        lblNombre.setText("Nombre:   " + alumno.getNombre());
        lblIdAlumno.setText("ID:           " + alumno.getIdAlumno());
        lblSemestre.setText("Semestre: " + alumno.getSemestre());
        lblPrograma.setText("Programa: " + alumno.getProgramaEducativo());
        btnConfirmar.setVisible(true);
        revalidate();
        repaint();
    }

    public void mostrarAlumnoYaInscrito(AlumnoDTO alumno) {
        lblNombre.setText("Nombre:   " + alumno.getNombre());
        lblIdAlumno.setText("ID:           " + alumno.getIdAlumno());
        lblSemestre.setText("Semestre: " + alumno.getSemestre());
        lblPrograma.setText("Programa: " + alumno.getProgramaEducativo());
        lblMensaje.setText("  ⚠ Este alumno ya está inscrito en este taller.");
        lblMensaje.setForeground(new Color(200, 100, 0));
        btnConfirmar.setVisible(false);
        revalidate();
        repaint();
    }

    /**
     * Muestra un error y oculta los datos.
     */
    public void mostrarError(String error) {
        lblMensaje.setText("  " + error);
        lblMensaje.setForeground(Color.RED);
        lblNombre.setText(" ");
        lblIdAlumno.setText(" ");
        lblSemestre.setText(" ");
        lblPrograma.setText(" ");
        btnConfirmar.setVisible(false);
        revalidate();
        repaint();
    }

    /**
     * Vuelve al estado inicial.
     */
    public void resetear() {
        campoId.setText("");
        lblMensaje.setText(" ");
        lblNombre.setText(" ");
        lblIdAlumno.setText(" ");
        lblSemestre.setText(" ");
        lblPrograma.setText(" ");
        btnConfirmar.setVisible(false);
    }

    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(BLANCO);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(ITSON_AZUL, 1, true),
                new EmptyBorder(12, 22, 16, 22)));

        // Barra top
        JPanel barraTop = new JPanel(new BorderLayout());
        barraTop.setOpaque(false);
        barraTop.setBorder(new EmptyBorder(0, 0, 8, 0));
        JLabel lblTitulo = new JLabel("Datos del Alumno");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 13));
        lblTitulo.setForeground(ITSON_AZUL);
        btnCerrar = cerrarBtn();
        btnCerrar.addActionListener(e -> {
            if (onCerrarClick != null) {
                onCerrarClick.run();
            }
        });
        barraTop.add(lblTitulo, BorderLayout.WEST);
        barraTop.add(btnCerrar, BorderLayout.EAST);

        // Contenido
        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setOpaque(false);

        JPanel filaId = rowPanel();
        JLabel lId = boldLabel("Ingresa tu ID: ");
        campoId = new JTextField(10);
        campoId.setFont(new Font("Arial", Font.PLAIN, 13));
        campoId.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE_TARJETA), new EmptyBorder(3, 8, 3, 8)));
        btnBuscar = itsonBtn("Buscar", ITSON_AZUL, ITSON_AZUL_PRESS);
        btnBuscar.addActionListener(e -> buscarAlumno());
        campoId.addActionListener(e -> buscarAlumno());
        filaId.add(lId);
        filaId.add(campoId);
        filaId.add(Box.createHorizontalStrut(6));
        filaId.add(btnBuscar);

        lblMensaje = new JLabel(" ");
        lblMensaje.setFont(new Font("Arial", Font.PLAIN, 11));
        lblMensaje.setForeground(Color.RED);
        lblMensaje.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblNombre = boldLabel(" ");
        lblIdAlumno = boldLabel(" ");
        lblSemestre = boldLabel(" ");
        lblPrograma = boldLabel(" ");

        btnConfirmar = itsonBtn("Confirmar Inscripción", ITSON_AZUL, ITSON_AZUL_PRESS);
        btnConfirmar.setVisible(false);
        btnConfirmar.addActionListener(e -> {
            if (tallerIdActual != null) {
                control.confirmarInscripcion(campoId.getText().trim(), tallerIdActual);
            }
        });
        JPanel rowBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rowBtn.setOpaque(false);
        rowBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        rowBtn.add(btnConfirmar);

        contenido.add(filaId);
        contenido.add(Box.createVerticalStrut(4));
        contenido.add(lblMensaje);
        contenido.add(Box.createVerticalStrut(4));
        contenido.add(lblNombre);
        contenido.add(lblIdAlumno);
        contenido.add(lblSemestre);
        contenido.add(lblPrograma);
        contenido.add(rowBtn);

        add(barraTop, BorderLayout.NORTH);
        add(contenido, BorderLayout.CENTER);
    }

    private void buscarAlumno() {
        String id = campoId.getText().trim();
        if (id.isEmpty()) {
            lblMensaje.setText("  Ingresa un ID válido.");
            return;
        }
        lblMensaje.setText(" ");
        control.buscarAlumno(id);
    }

    private JLabel boldLabel(String txt) {
        JLabel l = new JLabel(txt);
        l.setFont(new Font("Arial", Font.BOLD, 13));
        l.setForeground(TEXTO_OSCURO);
        l.setAlignmentX(Component.LEFT_ALIGNMENT);
        return l;
    }

    private JPanel rowPanel() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 2));
        p.setOpaque(false);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);
        return p;
    }

    private JButton cerrarBtn() {
        Color rojo = ROJO_CERRAR;
        Color rojoPress = ROJO_CERRAR_PRESS;
        JButton btn = new JButton("X") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isPressed() ? rojoPress : rojo);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(new EmptyBorder(3, 10, 3, 10));
        btn.setToolTipText("Cerrar");
        return btn;
    }

    private JButton itsonBtn(String txt, Color bg, Color bgPress) {
        JButton btn = new JButton(txt) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(isEnabled() ? (getModel().isPressed() ? bgPress : bg) : new Color(160, 160, 160));
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
