package hilos;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HiloCuentaAtras implements Runnable {
	private volatile boolean ejecutar = true;
	private volatile boolean pausado = false; // Variable para pausar el hilo
	private int hora, minutos, segundos;
	private JLabel lblHora;
	private JLabel lblMinuto;
	private JLabel lblSegundo;

	public HiloCuentaAtras(int hora, int minutos, int segundos, JLabel lblHora, JLabel lblMinuto, JLabel lblSegundo) {
		super();
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
		this.lblHora = lblHora;
		this.lblMinuto = lblMinuto;
		this.lblSegundo = lblSegundo;

	}

	// Método para pausar el hilo
	public synchronized void pausar() {
		pausado = true;
	}

	// Método para reanudar el hilo
	public synchronized void reanudar() {
		pausado = false;
		notify(); // Notificar para salir del estado de espera
	}

	// Método para detener el hilo
	public void detener() {
		ejecutar = false;

	}

	@Override
	public void run() {
		while (ejecutar) {
			synchronized (this) {
				while (pausado) {
					try {
						wait(); // Esperar hasta que se llame a reanudar
					} catch (InterruptedException e) {

					}
				}
			}
			// Verificar si el tiempo ha llegado a cero
			if (hora == 0 && minutos == 0 && segundos == 0) {
				pausar(); // Pausar el hilo al alcanzar el tiempo
			}

			// Decrementar los segundos y manejar la transicion de hora minutos y segundos
			if (segundos == 0) {
				if (minutos == 0) {
					if (hora > 0) {
						hora--;
						minutos = 60;
					}

				}else if (minutos > 0) {
					minutos--;
					segundos = 59;
				}
			} else {
				segundos--;
			}

			// Actualizar el texto de los JLabel en el hilo de la UI

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					lblHora.setText(String.format("%02d", hora));
					lblMinuto.setText(String.format("%02d", minutos));
					lblSegundo.setText(String.format("%02d", segundos));
				}
			});
			// Esperar un segundo antes de actualizar el tiempo
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				ejecutar = false;
				System.out.println(" detenido.");
			}
		}
	}

}
