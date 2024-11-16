package ejercicio7;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Carrera extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblCaballoGanador;
    private JProgressBar[] barras;
    private int[] prioridades; // Arreglo para almacenar las prioridades
    private HiloCaballo[] hilos;
    private JButton btnEmpezar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Carrera frame = new Carrera();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Carrera() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        barras = new JProgressBar[4];
        prioridades = new int[4]; // Inicializar prioridades
        for (int i = 0; i < 4; i++) {
            barras[i] = new JProgressBar();
            barras[i].setBounds(100, 100 + (i * 70), 300, 30);
            contentPane.add(barras[i]);
            prioridades[i] = 5; // Prioridad predeterminada
        }

        JLabel[] lblCaballos = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            lblCaballos[i] = new JLabel("Caballo " + (i + 1));
            lblCaballos[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
            lblCaballos[i].setBounds(10, 110 + (i * 70), 70, 25);
            contentPane.add(lblCaballos[i]);
        }

        lblCaballoGanador = new JLabel("");
        lblCaballoGanador.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblCaballoGanador.setBounds(230, 31, 70, 25);
        contentPane.add(lblCaballoGanador);

        btnEmpezar = new JButton("Empieza la carrera");
        btnEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnEmpezar.setBounds(160, 372, 150, 30);
        btnEmpezar.addActionListener(e -> iniciarCarrera());
        contentPane.add(btnEmpezar);
       
        JButton btnConfigurar = new JButton("Configurar Prioridades");
        btnConfigurar.setBounds(30, 430, 180, 30);
        btnConfigurar.addActionListener(e -> abrirVentanaPrioridades());
        contentPane.add(btnConfigurar);
    }

    private void iniciarCarrera() {
        lblCaballoGanador.setText(""); // Reiniciar el ganador
        btnEmpezar.setVisible(false);
        for (int i = 0; i < 4; i++) {
            HiloCaballo hilos = new HiloCaballo(barras[i], "Caballo " + (i + 1), lblCaballoGanador);
            hilos.setPriority(prioridades[i]); // Asignar prioridad del caballo
            hilos.start();
        }
    }

    public void setPrioridadCaballo(int index, int prioridad) {
        if (index >= 0 && index < 4) {
            prioridades[index] = prioridad; // Actualizar la prioridad del caballo
        }
    }

    private void abrirVentanaPrioridades() {
        Prioridades ventanaPrioridades = new Prioridades(this);
        ventanaPrioridades.setVisible(true);
    }

}
