package ejercicio1;

import java.io.IOException;
import java.util.Map;

public class Ejer1 {
	public static void main(String[] args) {
		/*
		 * Ejecutar una aplicación de Windows. (Bloc de notas, Word, …)
		 */
		
		System.out.println("Vamos a lanzar el notepad");
		String infoProceso="notepad.exe";
		try {
			//PREPARAMOS EL PROCESO
			ProcessBuilder processBuilder=new ProcessBuilder(infoProceso);
			
			//SI QUISIERAMOS OBTENER INFORMACION SOBRE EL ENTORNO DE EJECUCUION DEL PROCESO
			Map<String, String>environment = processBuilder.environment();
		
			//Ejecutamos el Proceso
			Process proceso = processBuilder.start();
			
		
			int codigoRetorno=proceso.waitFor();
		
			
		}catch(IOException | InterruptedException e ) {
			e.printStackTrace();
		}

	}
}
