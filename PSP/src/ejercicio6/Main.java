package ejercicio6;

public class Main {
	public static void main(String[] args) {
		 Buffer b = new Buffer();
	        Productor p = new Productor(b);
	        Consumidor c = new Consumidor(b);

	        p.start(); // Inicia el hilo del productor
	        c.start(); // Inicia el hilo del consumidor

	        try {
	            p.join(); // Espera a que el productor termine
	            c.join(); // Espera a que el consumidor termine
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt(); // Restaura el estado de interrupción
	        }
	}
}
