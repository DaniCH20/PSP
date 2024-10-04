package Ejer4;

public class Principal {

	public static void main(String[] args) {
		DetonadorConRetardo d1=new DetonadorConRetardo("Bomba1",5);
		DetonadorConRetardo d2=new DetonadorConRetardo("Bomba2",5);
		DetonadorConRetardo d3=new DetonadorConRetardo("Bomba3",5);
		DetonadorConRetardo d4=new DetonadorConRetardo("Bomba4",5);
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		try {
			d1.join();
			d2.join(); // Interrumpe el proceso durnate 8 segundos
			d3.join();
			d4.join();
		} catch (InterruptedException e) {

			System.out.printf("Fin del Programa");
		}
	}

}
