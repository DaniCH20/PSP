package hilos;

public class EjemploJoin {

	public static void main(String[] args) {
		Hilos h1 = new Hilos("Hilo1", 1);
		Hilos h2 = new Hilos("Hilo2", 50);
		Hilos h3 = new Hilos("Hilo3", 1);
		Hilos h4 = new Hilos("Hilo4", 1);

		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h4.setPriority(Thread.MAX_PRIORITY);//Asignamos una prioridad a los hilos si tienen el mismo tiempo este demorara menos
		try {
			Thread.sleep(8000);
			h2.interrupt();
			h1.join();
			h2.join(); // Interrumpe el proceso durnate 8 segundos
			h3.join();
			h4.join();
		} catch (InterruptedException e) {

			System.out.printf("Fin del Programa");
		}
	}

}
