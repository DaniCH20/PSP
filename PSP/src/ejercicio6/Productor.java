package ejercicio6;

import java.util.Random;

public class Productor extends Thread{
	 private Buffer buffer;
	    private Random random;

	    public Productor(Buffer buffer) {
	        this.buffer = buffer;
	        this.random = new Random();
	    }

	    @Override
	    public void run() {
	        for (int i = 0; i < 10; i++) { // 10 iteraciones
	            char c = (char) ('A' + random.nextInt(26)); // Genera un caracter aleatorio entre 'A' y 'Z'
	            buffer.poner(c); // Pone el caracter en el buffer
	            System.out.println("Productor ha puesto: " + c);

	            try {
	                Thread.sleep(1000); // Pausa de 1 segundo se puede ajustar
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt(); // Restaura el estado de interrupción
	            }
	        }
	    }
}
