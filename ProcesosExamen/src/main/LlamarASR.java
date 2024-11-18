package main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class LlamarASR {
	private static String SALIDA = ".\\src\\main\\salida.txt";
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce el primer parametro");
		int num1 = teclado.nextInt();
		System.out.println("Introduce el segundo parametro");
		int num2 = teclado.nextInt();
		System.out.println("Introduce el tercer parametro");
		int num3 = teclado.nextInt();
		String numero1=num1+"";
		String numero2=num2+"";
		String numero3=num3+"";
		File logSalida = new File(SALIDA);
		try {
			ProcessBuilder pb = new ProcessBuilder("java", "-cp", "..\\ProcesosExamen\\src", "main.SumadorRestador",numero1,numero2,numero3);
			pb.redirectErrorStream(true); // Redirigir la salida de error

			Process p = pb.start();
			InputStream is = p.getInputStream();
			// Lee la salida del proceso
			
			if (p != null) {
				System.out.println("PID:"+p.pid());
			}
			ProcessHandle procesoPadre = ProcessHandle.current().parent().orElse(null);
			if (procesoPadre != null) {
				System.out.println("PID Padre:" + procesoPadre.pid());
			} else {
				System.out.println("No hay PID del proceso padre");

			}
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
