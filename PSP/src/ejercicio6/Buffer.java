package ejercicio6;

import java.util.Scanner;

public class Buffer {
	private char contenido; // Almacena el caracter
	private boolean bufferLleno; // Indica si el buffer está lleno
	private Scanner teclado = new Scanner(System.in);

	// Método para poner un caracter en el buffer
	public synchronized void poner(char c) {

		this.contenido = c; // Guarda el carácter
		bufferLleno = true; // Marca el buffer como lleno

	}

	// Método para recoger un caracter del buffer
	public synchronized char recoger() {
		char c = ' ';
		// Si el buffer esta lleno
		if (bufferLleno) {
			c = this.contenido; // Obtiene el carácter
			bufferLleno = false; // Marca el buffer como vacío
		} else {
			System.out.println("Escribe un caracter para rellenar");
			String input = teclado.next(); // Lee la entrada como una cadena

			// Verficamos si se ha introducido un caracter
			if (input.length() > 0) {
				c = input.charAt(0); // Obtenemos el primer caracter
				System.out.println("Carácter leido: " + c);
			} else {
				System.out.println("No se ha introducido ningún carácter.");
			}
			
			bufferLleno = false; // Marca el buffer como vacio
			
		}

		return c;
	}
}
