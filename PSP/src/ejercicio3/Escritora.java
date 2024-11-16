package ejercicio3;

public class Escritora extends Thread {
	private boolean contador;

	public Escritora(String nom, boolean contador) {
		super(nom);
		this.contador = contador;
	}

	public void run() {
		if (contador) {
			for (int i = 1; i < 30; i++) {
				System.out.println(getName() + ":" + i);
				try {
					sleep(1000);
				} catch (InterruptedException ignore) {
					System.out.println("Fallo corectamente");
				}
			}
		} else {
			String abecedario = "abcdefghijklmnñopqrstuvwxyz";
			for (int i = 0; i < abecedario.length(); i++) { // Cambiado a 0 y < length
				System.out.println(getName() + ": " + abecedario.charAt(i)); // Usando charAt para imprimir letras
				try {
					sleep(1000);
				} catch (InterruptedException ignore) {
					System.out.println("Fallo correctamente");
				}
			}
		}
		System.out.println("Fin bucle " + getName());
	}
}
