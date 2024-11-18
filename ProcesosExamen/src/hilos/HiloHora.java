package hilos;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HiloHora extends Thread{

	private volatile boolean ejecutar = true;
	private int horas,minutos, segundos;
	private JLabel lblHora;
	private JLabel lblMinuto;
	private JLabel lblSegundo;
	
	private boolean estaPausado = false;

	public HiloHora(int horas, int minutos, int segundos,JLabel lblHora, JLabel lblMinuto, JLabel lblSegundo) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
		this.lblHora = lblHora;
		this.lblMinuto = lblMinuto;
		this.lblSegundo = lblSegundo;
	}

	public void run() {
		while (ejecutar) {
			if (!estaPausado) {
				if (segundos == 59) {
					segundos = 0;
					minutos++;
					if(minutos==59) {
						minutos=0;
						horas++;
					}
				} else {
					segundos++;
				}

				// Actualizar el texto de los JLabel en el hilo de la UI
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						lblHora.setText(String.format("%02d", horas));
						lblMinuto.setText(String.format("%02d", minutos));
						lblSegundo.setText(String.format("%02d", segundos));
					}
				});
			}
			try {
				sleep(1000); // Esperar un segundo antes de actualizar el tiempo
			} catch (InterruptedException e) {
				ejecutar = false;
				System.out.println(getName() + " detenido.");
			}
		}
	}

	public void reiniciar() {
		minutos = 0;
		segundos = 0;
		estaPausado = false;
		// Actualizar el texto de los JLabel en el hilo de la UI
		SwingUtilities.invokeLater(() -> {
			lblMinuto.setText(String.format("%02d", minutos));
			lblSegundo.setText(String.format("%02d", segundos));
		});
	}

	public void detener() {
		ejecutar = false;
	}

	public void continuar() {
		estaPausado = false;
	}

	public void pausar() {
		estaPausado = true;
	}
}
