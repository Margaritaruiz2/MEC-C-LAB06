import java.util.Scanner;
import java.util.Random;

public class JuegosDeAzar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Crear un objeto para cada juego
        Dados dados = new Dados();
        Tragamonedas tragamonedas = new Tragamonedas();

        // Crear un hilo para cada juego
        Thread hiloDados = new Thread(dados);
        Thread hiloTragamonedas = new Thread(tragamonedas);

        // Mostrar el menú principal
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Juego de dados");
            System.out.println("2. Juego tragamonedas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    // Iniciar el hilo del juego de dados
                    hiloDados.start();
                    break;
                case 2:
                    // Iniciar el hilo del juego tragamonedas
                    hiloTragamonedas.start();
                    break;
                case 0:
                    // Salir del programa
                    System.out.println("Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opcion != 0);

        // Esperar a que los hilos finalicen
        try {
            hiloDados.join();
            hiloTragamonedas.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar a los hilos");
        }
    }
}

class Dados implements Runnable {
    public void run() {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        int lanzamientos = 0;

        System.out.println("Bienvenido al juego de dados!");
        System.out.println("Presione ENTER para lanzar los dados...");

        while (!input.nextLine().equals("exit")) {
            int dado1 = rnd.nextInt(6) + 1;
            int dado2 = rnd.nextInt(6) + 1;
            lanzamientos++;

            System.out.printf("Lanzamiento %d: %d + %d = %d\n", lanzamientos, dado1, dado2, dado1 + dado2);
            System.out.print("Presione ENTER para lanzar los dados de nuevo o escriba 'exit' para salir...");
        }
        System.out.println("Fin del juego de dados.");
    }
}

class Tragamonedas implements Runnable {
    public void run() {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        int lanzamientos = 0;

        System.out.println("Bienvenido al juego tragamonedas!");
        System.out.println("Presione ENTER para girar los tambores...");

        while (!input.nextLine().equals("exit")) {
            int tambor1 = rnd.nextInt(10);
            int tambor2 = rnd.nextInt(10);
            int tambor3 = rnd.nextInt(10);
            lanzamientos++;

            System.out.printf("Giro %d: %d %d %d\n", lanzamientos, tambor1, tambor2, tambor3);

            
