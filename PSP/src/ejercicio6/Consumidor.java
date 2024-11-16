package ejercicio6;

public class Consumidor extends Thread{
	private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // 10 iteraciones
            char c = buffer.recoger(); // Recoge el caracter del buffer
            System.out.println("Consumidor ha recogido: " + c);

            try {
                Thread.sleep(1000); // Pausa de 1 segundo 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaura el estado de interrupción
            }
        }
    }

}
