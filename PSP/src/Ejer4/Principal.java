package Ejer4;

public class Principal {

    public static void main(String[] args) {
        DetonadorConRetardo d1 = new DetonadorConRetardo("Bomba1", 5);
        DetonadorConRetardo d2 = new DetonadorConRetardo("Bomba2", 4);
        DetonadorConRetardo d3 = new DetonadorConRetardo("Bomba3", 3);
        DetonadorConRetardo d4 = new DetonadorConRetardo("Bomba4", 6);

        d1.start();
        d2.start();
        d3.start();
        d4.start();

        try {
            d1.join();
            d2.join();
            d3.join();
            d4.join();
        } catch (InterruptedException e) {
            // Manejo de la excepción si ocurre
            System.out.println("Se interrumpió un hilo");
        }

        // Mensaje de fin del programa
        System.out.println("Fin del Programa");
    }
}
