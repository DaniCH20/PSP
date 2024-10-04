package hilos;

public class Hilos extends Thread {

	private int n;

	public Hilos(String nom, int n) {
		super(nom);
		this.n = n;
	}

	public void run() {
		for (int i = 1; i < n; i++) {
			System.out.println(getName() + ":" + i);
			try {
				sleep(1000);

			} catch (InterruptedException ignore) {
				i = n;
				System.out.println("Fallo corectamente");
			}
		}
		System.out.println("Fin bucle" + getName());
	}

}
