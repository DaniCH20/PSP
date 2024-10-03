package ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Ejer2 {
	/*
	 * Ejecutar un comando de windows. (Dir, Taskmgr, …) y mostrar su resultado por pantalla.
	 */
	public static void main(String[] args) {
		
		 ProcessBuilder pb = new ProcessBuilder("CMD","/c","tasklist");

         try 
         {
        	 Process p=pb.start();
             InputStream is= p.getInputStream();
 			
 			
 			int c;
 			while((c= is.read())!= -1)
 				System.out.print((char)c);
 			is.close();
            
         } 
         catch (IOException e) 
         {
             System.out.println(e.getMessage());
         }  

	}

}
