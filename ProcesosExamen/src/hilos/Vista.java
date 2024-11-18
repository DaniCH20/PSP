package hilos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Date date = new java.util.Date();
	private JLabel lblHora = new JLabel("00");
	private JLabel lblMinutos = new JLabel("00");
	private JLabel lblSegundos = new JLabel("00");
	private JLabel mensaje = new JLabel("El hilo <<hora>> ha comenzado");
	private JButton btnIniciar = new JButton("Iniciar");
	private JButton btnPausar = new JButton("Pausar");
	private JButton btnParar = new JButton("Parar");
	HiloCuentaAtras reloj = new HiloCuentaAtras(1, 30, 0, lblHora, lblMinutos, lblSegundos);
	Thread reloj1 = new Thread(reloj, "reloj");
	private final JLabel lblhoraR = new JLabel("00");
	private final JLabel lblMinutoR = new JLabel("00");
	private final JLabel lblSegundoR = new JLabel("00");
	HiloHora hora = new HiloHora(date.getHours(), date.getMinutes(), date.getSeconds(), lblhoraR, lblMinutoR,lblSegundoR);
	private final JLabel lblNewLabel = new JLabel(":");
	private final JLabel lblNewLabel_1 = new JLabel(":");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		hora.start();
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				reloj1.start();
				mensaje.setText("El hilo <<" + reloj1.getName() + ">> ha comenzado");
				btnIniciar.setEnabled(false);
				btnPausar.setEnabled(true);
				btnParar.setEnabled(true);
			}
		});
		btnIniciar.setBounds(10, 113, 89, 23);
		contentPane.add(btnIniciar);

		btnPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (btnPausar.getText() == "Pausar") {
					btnPausar.setText("Reanudar");
					btnParar.setEnabled(false);
					reloj.pausar();

				} else {
					btnPausar.setText("Pausar");
					btnParar.setEnabled(true);
					reloj.reanudar();
				}

			}
		});
		btnPausar.setBounds(109, 113, 89, 23);
		contentPane.add(btnPausar);

		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje.setText("El hilo <<" + reloj1.getName() + ">> ha finalizado");
				btnIniciar.setEnabled(true);
				btnPausar.setEnabled(false);
				btnParar.setEnabled(false);
				reloj.detener();

			}
		});
		btnParar.setBounds(208, 113, 89, 23);
		contentPane.add(btnParar);

		lblSegundos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSegundos.setBounds(222, 40, 30, 25);
		contentPane.add(lblSegundos);

		lblMinutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMinutos.setBounds(182, 40, 30, 25);
		contentPane.add(lblMinutos);

		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHora.setBounds(132, 40, 30, 25);
		contentPane.add(lblHora);

		JLabel lblNewLabel_1_1 = new JLabel(":");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(169, 40, 15, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel(":");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(210, 40, 15, 25);
		contentPane.add(lblNewLabel_1_1_1);

		mensaje.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mensaje.setBounds(42, 206, 283, 30);
		contentPane.add(mensaje);

		btnPausar.setEnabled(false);
		btnParar.setEnabled(false);
		lblhoraR.setHorizontalAlignment(SwingConstants.RIGHT);
		lblhoraR.setBounds(314, 114, 20, 20);

		contentPane.add(lblhoraR);
		lblMinutoR.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutoR.setBounds(339, 114, 20, 20);

		contentPane.add(lblMinutoR);
		lblSegundoR.setBounds(369, 114, 20, 20);

		contentPane.add(lblSegundoR);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(334, 117, 10, 14);

		contentPane.add(lblNewLabel);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(359, 117, 10, 14);

		contentPane.add(lblNewLabel_1);
	}
}
