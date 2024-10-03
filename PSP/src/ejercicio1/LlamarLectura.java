package ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LlamarLectura {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce una cadena");    
        String cadena = teclado.nextLine();
        
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "..\\PSP\\src", "ejercicio1.EjemploLectura", cadena);
            pb.redirectErrorStream(true); // Redirigir la salida de error
            
            Process p = pb.start();
            InputStream is = p.getInputStream();
            // Lee la salida del proceso
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();

            // Espera a que el proceso termine
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            teclado.close(); // Cierra el Scanner
        }
    }
}
