package Ejer4;

public class DetonadorConRetardo extends Thread {
    private int contador;

    public DetonadorConRetardo(String nom, int contador) {
        super(nom);
        this.contador = contador;
    }

    public void run() {
        while (contador > 0) {
            System.out.println(getName() + ": " + contador);
            contador--; // Reducir el contador
            try {
                sleep(1000); // Espera de 1 segundo
            } catch (InterruptedException ignore) {
            }
        }
        System.out.println("Fin bucle " + getName());
    }
}
