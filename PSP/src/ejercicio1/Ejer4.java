package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejer4 {
	/*
	 * Haz un programa que muestre los procesos en ejecución.
	 */
	public static void main(String[] args) {
		
		 ProcessBuilder pb = new ProcessBuilder("CMD","/c","tasklist");
       try 
       {
      	 Process p=pb.start();
      // Se lee la salida
      	InputStream is = p.getInputStream();
      	InputStreamReader isr = new InputStreamReader(is);
      	BufferedReader br = new BufferedReader(isr);

      	String line;
      	while ((line = br.readLine()) != null) {
      	  System.out.println(line);
      	}
       } 
       catch (IOException e) 
       {
           System.out.println(e.getMessage());
       }  

	}
}
