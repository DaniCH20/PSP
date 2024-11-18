package preparacionExamen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Hilo extends Thread {
	private volatile boolean ejecutar = true;
	private volatile boolean pausado = false; // Variable para pausar el hilo
	private int minutos, segundos;
	private int limiteMinutos, limiteSegundos;


	public Hilo(String nombre, int minutos, int segundos) {
		super(nombre);
		this.minutos = minutos;
		this.segundos = segundos;
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
		interrupt();
	}

	@Override
	public void run() {
		while (ejecutar && !isInterrupted()) {
			synchronized (this) {
				while (pausado) {
					try {
						wait(); // Esperar hasta que se llame a reanudar
					} catch (InterruptedException e) {
						interrupt();
					}
				}
			}

			// Lógica de conteo regresivo
			if (segundos == 59) {
				segundos = 0;
				minutos++;
			} else {
				segundos++;
			}
			// Imprimir el tiempo restante en la consola
			System.out.println(getName() + ": " + minutos + segundos);
			// Verificar si se alcanzó el límite
			if (minutos == limiteMinutos && segundos == limiteSegundos) {
				System.out.println("¡Tiempo límite alcanzado en " + getName() + "! Es hora del descanso.");
				segundos = 0;
				minutos = 0;
				pausar(); // Pausar automáticamente cuando se alcance el límite
			}
			try {
				sleep(1000); // Pausa de un segundo antes de actualizar el tiempo
			} catch (InterruptedException e) {
				ejecutar = false;
				System.out.println(getName() + " detenido.");
				Thread.currentThread().interrupt();
			}
		}
	}

	// Métodos para establecer límites
	public void setMinutos(int minutos) {
		this.limiteMinutos = minutos;
	}

	public void setSegundosRestantes(int segundosRestantes) {
		this.limiteSegundos = segundosRestantes;
	}
}
