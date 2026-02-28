/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package itson.presentacion.vista;

import itson.entidades.DTOs.TallerDTO;
import itson.presentacion.control.ControlInscripcion;
import itson.presentacion.modelo.IObserver;
import itson.presentacion.modelo.ISubject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author angel
 */
public class VistaInscripcion extends javax.swing.JFrame implements IObserver {

    private static final Color FONDO_GRIS = new Color(245, 246, 248);
    private static final Color ITSON_AZUL = new Color(0, 87, 168);
    private static final Color BLANCO = Color.WHITE;

    private final ControlInscripcion control;

    private final UI_ListaTalleres uiListaTalleres;
    private final UI_DatosTaller uiDatosTaller;
    private final UI_DatosAlumnos uiDatosAlumnos;
    private final UI_Ticket uiTicket;

    private final JPanel cardContenedor;
    private final CardLayout cardLayout;

    private static final String CARD_VACIO = "vacio";
    private static final String CARD_ALUMNO = "alumno";
    private static final String CARD_TICKET = "ticket";

    private JLayeredPane layeredPane;

    public VistaInscripcion(ControlInscripcion control, ISubject modeloSubject) {
        this.control = control;

        uiListaTalleres = new UI_ListaTalleres(control);
        uiDatosTaller = new UI_DatosTaller(control);
        uiDatosAlumnos = new UI_DatosAlumnos(control);
        uiTicket = new UI_Ticket(control);

        cardLayout = new CardLayout();
        cardContenedor = new JPanel(cardLayout);
        cardContenedor.setOpaque(false);
        cardContenedor.add(new JPanel() {
            {
                setOpaque(false);
            }
        }, CARD_VACIO);
        cardContenedor.add(uiDatosAlumnos, CARD_ALUMNO);
        cardContenedor.add(uiTicket, CARD_TICKET);
        cardLayout.show(cardContenedor, CARD_VACIO);

        modeloSubject.addObserver(this);

        uiDatosTaller.setOnInscribirseClick(() -> {
            uiDatosAlumnos.setTallerIdActual(control.getTallerSeleccionado().getIdTaller());
            uiDatosAlumnos.mostrar();
            cardLayout.show(cardContenedor, CARD_ALUMNO);
            cardContenedor.setVisible(true);
            reLayout();
        });

        uiDatosAlumnos.setOnCerrarClick(() -> control.limpiarPantalla());

        initUI();
        setVisible(true);
    }

    // IObserver
    @Override
    public void update() {
        uiListaTalleres.cargarTalleres(control.getListaTalleres());

        uiDatosTaller.mostrarTaller(control.getTallerSeleccionado());

        if (!control.hayTaller()) {
            cardLayout.show(cardContenedor, CARD_VACIO);
            cardContenedor.setVisible(false);

        } else if (control.esExitosa()) {
            uiTicket.mostrarTicket(control.getAlumno(), control.getTallerSeleccionado());
            cardLayout.show(cardContenedor, CARD_TICKET);
            cardContenedor.setVisible(true);

        } else if (cardContenedor.isVisible()) {
            if (control.hayAlumno()) {
                if (control.alumnoYaInscrito()) {
                    uiDatosAlumnos.mostrarAlumnoYaInscrito(control.getAlumno());
                } else {
                    uiDatosAlumnos.mostrarAlumno(control.getAlumno());
                }
            } else if (control.getMensaje() != null) {
                uiDatosAlumnos.mostrarError(control.getMensaje());
            }
        }

        reLayout();
    }

    // UI
    private void initUI() {
        setTitle("Semana ISW – ITSON");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(920, 660);
        setMinimumSize(new Dimension(800, 580));
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(FONDO_GRIS);
        setContentPane(root);
        root.add(buildHeader(), BorderLayout.NORTH);
        root.add(buildCuerpo(), BorderLayout.CENTER);
    }

    private JPanel buildHeader() {
        JPanel h = new JPanel(new BorderLayout());
        h.setBackground(BLANCO);
        h.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, ITSON_AZUL),
                new EmptyBorder(14, 28, 14, 28)));

        JPanel logoPanel = new JPanel();
        logoPanel.setOpaque(false);
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));
        JLabel logoText = new JLabel("ITSON");
        logoText.setFont(new Font("Arial Black", Font.BOLD, 24));
        logoText.setForeground(ITSON_AZUL);
        JLabel slogan = new JLabel("Educar para Trascender");
        slogan.setFont(new Font("Arial", Font.ITALIC, 10));
        slogan.setForeground(ITSON_AZUL);
        logoPanel.add(logoText);
        logoPanel.add(slogan);

        JLabel titulo = new JLabel("SEMANA DE ISW");
        titulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 36));
        titulo.setForeground(ITSON_AZUL);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        h.add(logoPanel, BorderLayout.WEST);
        h.add(titulo, BorderLayout.CENTER);
        return h;
    }

    private JLayeredPane buildCuerpo() {
        layeredPane = new JLayeredPane();
        layeredPane.setBackground(FONDO_GRIS);
        layeredPane.setOpaque(true);

        layeredPane.add(uiListaTalleres, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(uiDatosTaller, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(cardContenedor, JLayeredPane.PALETTE_LAYER);
        cardContenedor.setVisible(false);

        layeredPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                reLayout();
            }
        });

        return layeredPane;
    }

    private void reLayout() {
        int W = layeredPane.getWidth();
        int H = layeredPane.getHeight();
        if (W == 0 || H == 0) {
            return;
        }
        int pad = 20;

        uiListaTalleres.setBounds(pad, pad,
                (int) (W * 0.38), (int) (H * 0.58));

        int dW = (int) (W * 0.43);
        uiDatosTaller.setBounds(W - dW - pad, pad,
                dW, (int) (H * 0.46));

        cardContenedor.setBounds(
                (int) (W * 0.20), (int) (H * 0.40),
                (int) (W * 0.56), (int) (H * 0.52));
    }

    public void cargarTalleres(List<TallerDTO> talleres) {
        uiListaTalleres.cargarTalleres(talleres);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
