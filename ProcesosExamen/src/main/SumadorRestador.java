package main;

import java.util.Scanner;

public class SumadorRestador {

	public static void main(String[] args) {

		try {
			if (args.length > 0) {
				Scanner sc = new Scanner(System.in);
				int resultado = 0;
				String num1 = args[0];
				String num2 = args[1];
				String num3 = args[2];
				int opcion = sc.nextInt();
				//Como no sabia como pasar un entero por la clase decidi pasar strings para luego transformarlos en int para la operacion
				int operador1 = sc.nextInt();
				int operador2 = sc.nextInt();
				if (opcion == 1)
					resultado = operador1 + operador2;
				else
					resultado = operador1 - operador2;
				System.out.println("Resultado: " + resultado);
				System.out.println("strings: " + num1 + num2 + num3);
				sc.close();
			} else {

			}
		} catch (Exception e) {
			System.out.println("Error" + e);
		}

	}

}
