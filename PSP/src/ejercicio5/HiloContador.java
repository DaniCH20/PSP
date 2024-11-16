package ejercicio5;

public class HiloContador extends Thread {
    private int n;
    private volatile boolean ejecutar = true;
    private int contador = 0; // Contador que se mostrará en la interfaz

    public HiloContador(String nom, int n) {
        super(nom);
        this.n = n;
    }

    public void run() {
        while (ejecutar && contador < n) {
            try {
                Thread.sleep(1000);
                contador++;
            } catch (InterruptedException e) {
                System.out.println(getName() + " fue finalizado");
                return;
            }
        }
        System.out.println(getName() + " fin");
    }

    public int getContador() {
        return contador; // Devuelve el contador actual
    }

    public void detener() {
        ejecutar = false; // Cambia la variable para que el hilo termine
    }
}
