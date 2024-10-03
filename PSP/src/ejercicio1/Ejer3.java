package ejercicio1;

import java.io.IOException;
import java.io.InputStream;

public class Ejer3 {
	/*
	 * Haz un programa que obtenga la dirección MAC y la muestre por pantalla
	 */
	public static void main(String[] args) {
		
		 ProcessBuilder pb = new ProcessBuilder("CMD","/c","getmac");
        try 
        {
       	 Process p=pb.start();
            InputStream is= p.getInputStream();
			System.out.println();
			
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
