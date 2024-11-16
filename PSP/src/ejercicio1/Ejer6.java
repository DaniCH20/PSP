package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejer6 {
	/*
	 * Programa que ejecuta un “.bat” previamente preparado y recoge la salida en un archivo y los errores en otro.
	 */
	//Definicion de rutas
	private static String RUTA_BAT = ".\\src\\ejercicio1\\prueba.bat";
	private static String SALIDA = ".\\src\\ejercicio1\\salida.txt";
	private static String ERRORES = ".\\src\\ejercicio1\\error.txt";

	public static void main(String[] args) {
		try {
			File file = new File(RUTA_BAT);

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", file.getAbsolutePath());

			Process process = pb.start();

			//Estos son los objetos de salida y error
			File logSalida = new File(SALIDA);
			File logError = new File(ERRORES);
				//Captura la salida  generada por el proceso
			try (BufferedReader readerSalida = new BufferedReader(new InputStreamReader(process.getInputStream()));
					//Captura los errores generados por el proceso
					BufferedReader readerError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
					
					BufferedWriter writerSalida = new BufferedWriter(new FileWriter(logSalida));
					//Escribe las lineas leidas en los archivos
					BufferedWriter writerError = new BufferedWriter(new FileWriter(logError))) {

				String line;
				while ((line = readerSalida.readLine()) != null) {
					System.out.println("Salida: " + line);
					writerSalida.write(line);
					writerSalida.newLine();
				}

				while ((line = readerError.readLine()) != null) {
					System.err.println("Error: " + line);
					writerError.write(line);
					writerError.newLine();
				}
			}

			int codigoSalida = process.waitFor();
			System.out.println("Proceso terminado con código: " + codigoSalida);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}