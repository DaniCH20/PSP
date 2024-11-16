package ejercicio5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblContador1, lblContador2, lblContador3;
	private JLabel lblPrioridad1, lblPrioridad2, lblPrioridad3, lblPri1, lblPri2, lblPri3;
	private HiloContador H1 = new HiloContador("Hilo1", 20);
	private HiloContador H2 = new HiloContador("Hilo2", 20);
	private HiloContador H3 = new HiloContador("Hilo3", 20);

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Ventana frame = new Ventana();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Componentes de la interfaz
		createComponents();

		// Iniciar los hilos

		H1.start();
		H2.start();
		H3.start();

		// Timer para actualizar los contadores en la interfaz
		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCounters();
			}
		});
		timer.start();
	}

	private void createComponents() {
		// Botones y etiquetas
		JButton btnMenos1 = new JButton("--");
		JButton btnMas1 = new JButton("++");
		JButton btnFinHilo1 = new JButton("Fin Hilo 1");

		JButton btnMenos2 = new JButton("--");
		JButton btnMas2 = new JButton("++");
		JButton btnFinHilo2 = new JButton("Fin Hilo 2");

		JButton btnMenos3 = new JButton("--");
		JButton btnMas3 = new JButton("++");
		JButton btnFinHilo3 = new JButton("Fin Hilo 3");

		JButton btnFinalizarTodos = new JButton("Finalizar todos");
		JLabel lblHilo1 = new JLabel("Hilo1:");
		JLabel lblHilo2 = new JLabel("Hilo2:");
		JLabel lblHilo3 = new JLabel("Hilo3:");

		// Posicionar componentes
		btnMenos1.setBounds(42, 39, 50, 25);
		btnMas1.setBounds(285, 39, 50, 25);
		btnFinHilo1.setBounds(142, 39, 100, 25);

		btnMenos2.setBounds(42, 75, 50, 25);
		btnMas2.setBounds(285, 75, 50, 25);
		btnFinHilo2.setBounds(142, 75, 100, 25);

		btnMenos3.setBounds(42, 111, 50, 25);
		btnMas3.setBounds(285, 111, 50, 25);
		btnFinHilo3.setBounds(142, 111, 100, 25);

		btnFinalizarTodos.setBounds(142, 169, 120, 25);
		lblHilo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHilo1.setBounds(73, 211, 30, 25);
		lblHilo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHilo2.setBounds(73, 253, 30, 25);
		lblHilo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHilo3.setBounds(73, 295, 30, 25);

		contentPane.add(btnMenos1);
		contentPane.add(btnMas1);
		contentPane.add(btnFinHilo1);
		contentPane.add(btnMenos2);
		contentPane.add(btnMas2);
		contentPane.add(btnFinHilo2);
		contentPane.add(btnMenos3);
		contentPane.add(btnMas3);
		contentPane.add(btnFinHilo3);
		contentPane.add(btnFinalizarTodos);

		// Contadores y prioridades
		lblContador1 = new JLabel("0");
		lblContador2 = new JLabel("0");
		lblContador3 = new JLabel("0");

		lblPri1 = new JLabel("Pri: ");
		lblPri2 = new JLabel("Pri: ");
		lblPri3 = new JLabel("Pri: ");
		lblPrioridad1 = new JLabel("0");
		lblPrioridad2 = new JLabel("0");
		lblPrioridad3 = new JLabel("0");

		lblContador1.setBounds(108, 212, 25, 25);
		lblContador2.setBounds(108, 253, 25, 25);
		lblContador3.setBounds(108, 295, 25, 25);

		lblPri1.setBounds(239, 212, 25, 25);
		lblPri2.setBounds(239, 253, 25, 25);
		lblPri3.setBounds(239, 295, 25, 25);
		lblPrioridad1.setBounds(269, 212, 25, 25);
		lblPrioridad2.setBounds(269, 253, 25, 25);
		lblPrioridad3.setBounds(269, 295, 25, 25);

		contentPane.add(lblContador1);
		contentPane.add(lblContador2);
		contentPane.add(lblContador3);
		contentPane.add(lblPrioridad1);
		contentPane.add(lblPrioridad2);
		contentPane.add(lblPrioridad3);
		contentPane.add(lblHilo1);
		contentPane.add(lblHilo2);
		contentPane.add(lblHilo3);
		contentPane.add(lblPri1);
		contentPane.add(lblPri2);
		contentPane.add(lblPri3);

		// ActionListeners para botones de prioridad
		btnMenos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = H1.getPriority();
				H1.setPriority(num - 1);
				lblPrioridad1.setText(Integer.toString(num));
			}
		});
		btnMas1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = H1.getPriority();
				H1.setPriority(num + 1);
				lblPrioridad1.setText(Integer.toString(num));
			}
		});
		btnMenos2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = H2.getPriority();
				H2.setPriority(num - 1);
				lblPrioridad2.setText(Integer.toString(num));
			}
		});
		btnMas2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = H2.getPriority();
				H2.setPriority(num + 1);
				lblPrioridad2.setText(Integer.toString(num));
			}
		});
		btnMenos3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = H3.getPriority();
				H3.setPriority(num - 1);
				lblPrioridad3.setText(Integer.toString(num));
			}
		});
		btnMas3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = H3.getPriority();
				H3.setPriority(num + 1);
				lblPrioridad3.setText(Integer.toString(num));
			}
		});

		// ActionListeners para finalizar hilos
		btnFinHilo1.addActionListener(e -> {
			H1.detener();
			System.out.println("Hilo 1 finalizado");
		});
		btnFinHilo2.addActionListener(e -> {
			H2.detener();
			System.out.println("Hilo 2 finalizado");
		});
		btnFinHilo3.addActionListener(e -> {
			H3.detener();
			System.out.println("Hilo 3 finalizado");
		});

		btnFinalizarTodos.addActionListener(e -> {
			H1.detener();
			H2.detener();
			H3.detener();
			System.out.println("Todos los hilos finalizados");
		});
	}

	private void updateCounters() {
		lblContador1.setText(String.valueOf(H1.getContador()));
		lblContador2.setText(String.valueOf(H2.getContador()));
		lblContador3.setText(String.valueOf(H3.getContador()));
	}

}
