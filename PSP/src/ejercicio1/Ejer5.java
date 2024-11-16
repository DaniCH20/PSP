package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class Ejer5 {
	/*
	 * Haz un programa que detecte si el bloc de notas se está ejecutando y en caso afirmativo cree un proceso que lo elimine de la ejecución (matar el proceso).
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
	      	//Se crea un string cmd que va a agregarse todas las lineas del comando
	      String cmd=null;
	      	while ((line = br.readLine()) != null) {
	      		 System.out.println(line);
	      		 cmd+=line;
	      	}
	      	//verificamos si el string cmd contiene esa cadena de caracteres 
	      	if(cmd.contains("Notepad.exe")) {
	      		//ejecutamo otro proceso que se encargara de matar al notepadd
	      		 ProcessBuilder pn = new ProcessBuilder("CMD","/c","taskkill /IM notepad.exe");
	      		pn.start();
	      		 System.out.println("Se elimino el notepad");
	      		
	      	}else {
	      		 System.out.println("No se elimino el notepad");
	      	}
	       } 
	       catch (IOException e) 
	       {
	           System.out.println(e.getMessage());
	       }  
	}
}
