package ejercicio7;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HiloCaballo extends Thread {
    private JProgressBar barra;
    private String caballo;
    private JLabel ganador;
    private Random random;

    public HiloCaballo(JProgressBar barra, String caballo, JLabel ganador) {
        this.barra = barra;
        this.caballo = caballo;
        this.ganador = ganador;
        this.random = new Random();
    }

    public void run() {
        while (barra.getValue() < 100) { // Mantener hasta que se complete
            int avance = random.nextInt(10); // Avance aleatorio entre 0 y 9
            barra.setValue(Math.min(barra.getValue() + avance, 100)); // Asegúrate de no superar el 100

            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaura el estado de interrupción
            }
        }

        // Si el caballo alcanza el 100, se declara como ganador
        if (barra.getValue() >= 100) {
            ganador.setText(caballo);
        }
    }
    
}
