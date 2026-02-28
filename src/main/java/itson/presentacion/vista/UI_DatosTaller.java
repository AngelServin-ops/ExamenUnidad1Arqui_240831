/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package itson.presentacion.vista;

import itson.entidades.DTOs.TallerDTO;
import itson.presentacion.control.ControlInscripcion;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author angel
 */
public class UI_DatosTaller extends javax.swing.JPanel {

    private static final Color ITSON_AZUL = new Color(0, 87, 168);
    private static final Color ITSON_AZUL_PRESS = new Color(0, 60, 120);
    private static final Color BLANCO = Color.WHITE;
    private static final Color TEXTO_OSCURO = new Color(20, 20, 20);
    private static final Color COLOR_INSCRITOS = new Color(0, 140, 70);
    private static final Color COLOR_LLENO = new Color(220, 38, 38);

    private final ControlInscripcion control;
    private Runnable onInscribirseClick;

    private JLabel lblNombre, lblInstructor, lblFecha, lblHorario, lblInscritos;
    private JButton btnInscribirse;

    public UI_DatosTaller(ControlInscripcion control) {
        this.control = control;
        initUI();
        setVisible(false);
    }

    public void setOnInscribirseClick(Runnable callback) {
        this.onInscribirseClick = callback;
    }

    public void mostrarTaller(TallerDTO t) {
        if (t == null) {
            setVisible(false);
            return;
        }

        DateTimeFormatter fmtFecha = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "MX"));
        DateTimeFormatter fmtHorario = DateTimeFormatter.ofPattern("HH:mm");

        lblNombre.setText(t.getNombreCurso());
        lblInstructor.setText("Instructor: " + t.getNombreInstructor());
        lblFecha.setText("Fecha: " + t.getFecha().format(fmtFecha));
        lblHorario.setText("Horario: " + t.getFecha().format(fmtHorario) + " hrs");

        if (!t.tieneLugar()) {
            lblInscritos.setText("Sin cupo disponible");
            lblInscritos.setForeground(COLOR_LLENO);
            btnInscribirse.setEnabled(false);
        } else {
            lblInscritos.setText("Inscritos: " + t.getInscritos() + " / " + (t.getInscritos() + t.getCapacidad()));
            lblInscritos.setForeground(COLOR_INSCRITOS);
            btnInscribirse.setEnabled(true);
        }

        setVisible(true);
        revalidate();
        repaint();
    }

    private void initUI() {
        setLayout(new BorderLayout(0, 8));
        setBackground(BLANCO);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(ITSON_AZUL, 1, true),
                new EmptyBorder(16, 20, 14, 20)));

        JPanel info = new JPanel(new GridLayout(0, 1, 0, 5));
        info.setOpaque(false);

        lblNombre = centeredLabel("", new Font("Arial", Font.BOLD, 13), ITSON_AZUL);
        lblInstructor = centeredLabel("", new Font("Arial", Font.PLAIN, 13), TEXTO_OSCURO);
        lblFecha = centeredLabel("", new Font("Arial", Font.PLAIN, 13), TEXTO_OSCURO);
        lblHorario = centeredLabel("", new Font("Arial", Font.PLAIN, 13), TEXTO_OSCURO);
        lblInscritos = centeredLabel("", new Font("Arial", Font.BOLD, 12), COLOR_INSCRITOS);

        info.add(lblNombre);
        info.add(lblInstructor);
        info.add(lblFecha);
        info.add(lblHorario);
        info.add(lblInscritos);
        add(info, BorderLayout.CENTER);

        btnInscribirse = itsonBtn("Inscribirse");
        btnInscribirse.addActionListener(e -> {
            if (onInscribirseClick != null) {
                onInscribirseClick.run();
            }
        });
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 4));
        footer.setOpaque(false);
        footer.add(btnInscribirse);
        add(footer, BorderLayout.SOUTH);
    }

    private JLabel centeredLabel(String txt, Font f, Color c) {
        JLabel l = new JLabel(txt, SwingConstants.CENTER);
        l.setFont(f);
        l.setForeground(c);
        return l;
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
