package ejercicio1;

public class EjemploLectura {
	public static void main(String[] args) {
		try {
        if (args.length > 0) {
            System.out.println("Cadena Escrita: " + args[0]);
        } else {
            System.out.println("No se proporcionó ninguna cadena.");
        }
		}catch(Exception e) {
			System.out.println("Error"+e);
        }
    }

}
