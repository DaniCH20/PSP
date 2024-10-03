package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Ejercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSystem;
	private JTextField txtCmd;
	private JTextField txtRepeat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 frame = new Ejercicio2();
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
	public Ejercicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 684, 461);
		contentPane.add(panel);
		panel.setLayout(null);

		txtSystem = new JTextField();
		txtSystem.setBounds(70, 89, 100, 25);
		panel.add(txtSystem);
		txtSystem.setColumns(10);

		txtCmd = new JTextField();
		txtCmd.setColumns(10);
		txtCmd.setBounds(290, 89, 100, 25);
		panel.add(txtCmd);

		txtRepeat = new JTextField();
		txtRepeat.setColumns(10);
		txtRepeat.setBounds(510, 91, 100, 25);
		panel.add(txtRepeat);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(70, 201, 100, 20);
		panel.add(lblNewLabel_1);

		JLabel lblPidPadre1 = new JLabel("");
		lblPidPadre1.setBounds(70, 237, 100, 20);
		panel.add(lblPidPadre1);

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setBounds(290, 201, 100, 20);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setBounds(290, 237, 100, 20);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setBounds(452, 206, 200, 20);
		panel.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_4_1 = new JLabel("");
		lblNewLabel_1_4_1.setBounds(452, 237, 222, 20);
		panel.add(lblNewLabel_1_4_1);

		JLabel lblNewLabel = new JLabel("PID");
		lblNewLabel.setBounds(10, 201, 100, 25);
		panel.add(lblNewLabel);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(10, 345, 100, 25);
		panel.add(lblResultado);

		JLabel lblPidPadre = new JLabel("PID Padre");
		lblPidPadre.setBounds(10, 237, 100, 25);
		panel.add(lblPidPadre);
		JButton btnSystem = new JButton("Start");
		btnSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infoProceso = txtSystem.getText();
				try {
					// PREPARAMOS EL PROCESO
					ProcessBuilder processBuilder = new ProcessBuilder(infoProceso);

					// SI QUISIERAMOS OBTENER INFORMACION SOBRE EL ENTORNO DE EJECUCUION DEL PROCESO
					Map<String, String> environment = processBuilder.environment();

					// Ejecutamos el Proceso
					Process proceso = processBuilder.start();
					if (proceso != null) {
						lblNewLabel_1.setText("" + proceso.pid());
					} else {
						JOptionPane.showMessageDialog(null, "No hay PID del proceso", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					ProcessHandle procesoPadre = ProcessHandle.current().parent().orElse(null);
					if (procesoPadre != null) {
						lblPidPadre1.setText("" + procesoPadre.pid());
					} else {
						JOptionPane.showMessageDialog(null, "No hay PID del proceso padre", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					int codigoRetorno = proceso.waitFor();
				} catch (IOException | InterruptedException es) {
					JOptionPane.showMessageDialog(null, "Error" + es, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSystem.setBounds(70, 125, 100, 25);
		panel.add(btnSystem);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(245, 267, 200, 182);
		panel.add(textArea);
		JButton btnCmd = new JButton("Start");
		btnCmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infoProceso = txtCmd.getText();
				try {
					ProcessBuilder pb = new ProcessBuilder("CMD", "/c", infoProceso);

					Process proceso = pb.start();
					InputStream is = proceso.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);

					String line;
					String temp = "";
					while ((line = br.readLine()) != null) {
						System.out.println(line);
						temp = temp.concat(line).concat("\n");

					}
					textArea.setText(temp);

					lblNewLabel_1_2.setText("" + proceso.pid());

					ProcessHandle procesoPadre = ProcessHandle.current().parent().orElse(null);
					if (procesoPadre != null) {
						lblNewLabel_1_3.setText("" + procesoPadre.pid());
					} else {
						JOptionPane.showMessageDialog(null, "No hay PID del proceso padre", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (IOException es) {
					JOptionPane.showMessageDialog(null, "Error" + es, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCmd.setBounds(290, 125, 100, 25);
		panel.add(btnCmd);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(462, 267, 200, 182);
		panel.add(textArea_1);
		JButton btnRepeat = new JButton("Start");
		btnRepeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infoProceso = txtRepeat.getText();
				try {
					ProcessBuilder pb = new ProcessBuilder("java", "-cp", "..\\PSP\\src", "ejercicio1.EjemploLectura", infoProceso);

					for(int i=0; i<5; i++) {
						Process proceso = pb.start();
						InputStream is = proceso.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader br = new BufferedReader(isr);
						
			            
						String line;
						String temp = "";
						while ((line = br.readLine()) != null) {
							
							temp = temp.concat(line).concat("\n");
	
						}
						textArea_1.append(temp);
	
						lblNewLabel_1_4.setText(lblNewLabel_1_4.getText()+" "+proceso.pid());
						proceso.waitFor();
						is.close();
					}
					ProcessHandle procesoPadre = ProcessHandle.current().parent().orElse(null);
					if (procesoPadre != null) {
						lblNewLabel_1_4_1.setText("" + procesoPadre.pid());
					} else {
						JOptionPane.showMessageDialog(null, "No hay PID del proceso padre", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					 
				} catch (IOException | InterruptedException  es) {
					JOptionPane.showMessageDialog(null, "Error" + es, "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnRepeat.setBounds(510, 125, 100, 25);
		panel.add(btnRepeat);

	}
}
