package preparacionExamen;

import java.util.Scanner;

public class Main {
    private Scanner teclado = new Scanner(System.in);
    private Hilo hilo1;
    private Hilo hilo2;
    private Hilo hilo3;

    public static void main(String[] args) {
        Main app = new Main();
        app.iniciar();
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = opcionMenuInicial();
            if (opcion != 0) {
                ejecutarOpcionMenuInicial(opcion);
            }
        } while (opcion != 0);

        System.out.println("Aplicación finalizada.");
    }

    private int opcionMenuInicial() {
        int ret = -1;
        do {
            try {
                escribirMenuInicial();
                System.out.print("Elija una opción: ");
                ret = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Introduzca un número.");
            }
        } while (ret < 0 || ret > 5);
        return ret;
    }

    private void escribirMenuInicial() {
        System.out.println("\n---- MENU ----");
        System.out.println("0 - SALIR");
        System.out.println("1 - Iniciar Hilo 1");
        System.out.println("2 - Iniciar Hilos 2 y 3");
        System.out.println("3 - Detener Hilos");
        System.out.println("4 - Pausar Hilo 1");
        System.out.println("5 - Reanudar Hilo 1");
        System.out.println("--------------");
    }

    private void ejecutarOpcionMenuInicial(int opcion) {
        switch (opcion) {
            case 0:
                System.out.println("¡Adiós!");
                detenerTodosLosHilos();
                break;
            case 1:
                iniciarHilo1();
                break;
            case 2:
                iniciarHilos23();
                break;
            case 3:
                detenerTodosLosHilos();
                break;
            case 4:
                pausarHilo(hilo1);
                break;
            case 5:
                reanudarHilo(hilo1);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void iniciarHilo1() {
        if (hilo1 == null || !hilo1.isAlive()) {
            hilo1 = new Hilo("Hilo 1", 0, 0);
            hilo1.setMinutos(0);
            hilo1.setSegundosRestantes(10);
            hilo1.start();
            System.out.println("Hilo 1 iniciado.");
        } else {
            System.out.println("El Hilo 1 ya está en ejecución.");
        }
    }

    private void iniciarHilos23() {
        if (hilo2 == null || !hilo2.isAlive()) {
            hilo2 = new Hilo("Hilo 2", 0, 0);
            hilo2.setMinutos(0);
            hilo2.setSegundosRestantes(15);
            hilo2.start();
        }
        if (hilo3 == null || !hilo3.isAlive()) {
            hilo3 = new Hilo("Hilo 3", 0, 0);
            hilo3.setMinutos(0);
            hilo3.setSegundosRestantes(20);
            hilo3.start();
        }
        System.out.println("Hilos 2 y 3 iniciados.");
    }

    private void detenerTodosLosHilos() {
        if (hilo1 != null && hilo1.isAlive()) {
            hilo1.detener();
        }
        if (hilo2 != null && hilo2.isAlive()) {
            hilo2.detener();
        }
        if (hilo3 != null && hilo3.isAlive()) {
            hilo3.detener();
        }
        System.out.println("Todos los hilos han sido detenidos.");
    }

    private void pausarHilo(Hilo hilo) {
        if (hilo != null && hilo.isAlive()) {
            hilo.pausar();
            System.out.println("Hilo " + hilo.getName() + " pausado.");
        } else {
            System.out.println("El hilo no está en ejecución.");
        }
    }

    private void reanudarHilo(Hilo hilo) {
        if (hilo != null && hilo.isAlive()) {
            hilo.reanudar();
            System.out.println("Hilo " + hilo.getName() + " reanudado.");
        } else {
            System.out.println("El hilo no está en ejecución.");
        }
    }
}
