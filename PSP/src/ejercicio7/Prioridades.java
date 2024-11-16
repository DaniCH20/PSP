package ejercicio7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prioridades extends JFrame {
    private JTextField[] textFields;
    private JButton btnGuardar;
    private Carrera carrera;

    public Prioridades(Carrera carrera) {
        this.carrera = carrera;

        setTitle("Asignar Prioridades");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        textFields = new JTextField[4];
        for (int i = 0; i < 4; i++) {
            panel.add(new JLabel("Caballo " + (i + 1)));
            textFields[i] = new JTextField("6"); 
            textFields[i].setBounds(100, 100 + (i * 70), 300, 40);
            panel.add(textFields[i]);
        }

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 430, 100, 30);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPrioridades();
            }
        });
        panel.add(btnGuardar);

        add(panel);
    }

    private void guardarPrioridades() {
        for (int i = 0; i < 4; i++) {
            try {
                int prioridad = Integer.parseInt(textFields[i].getText());
                carrera.setPrioridadCaballo(i, prioridad);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un número valido para la prioridad del caballo " + (i + 1));
                return;
            }
        }
        this.dispose(); // Cerrar la ventana después de guardar
    }
}
