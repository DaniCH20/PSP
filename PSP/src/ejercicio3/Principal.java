package ejercicio3;

public class Principal {
	public static void main(String[] args) {
		Escritora d1 = new Escritora("Escritora1", true);
		Escritora d2 = new Escritora("Escritora2", false);

		d1.start();
		d2.start();

		try {
			d1.join();
			d2.join();

		} catch (InterruptedException e) {
			// Manejo de la excepción si ocurre
			System.out.println("Se interrumpió un hilo");
		}

		// Mensaje de fin del programa
		System.out.println("Fin del Programa");
	}
}
