package juego;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    // Opciones posibles
    private String[] opciones = {"piedra", "papel", "tijera"};
    // Crear un objeto Scanner para leer la entrada del usuario
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            String eleccionUsuario = elegirElementoUsuario(scanner);
            String eleccionComputadora = elegirElementoComputadora(opciones);

            Jugada jugadaUsuario = obtenerJugada(eleccionUsuario);
            Jugada jugadaComputadora = obtenerJugada(eleccionComputadora);

            // Mostrar las elecciones de ambos jugadores
            System.out.println("Tu elección: " + eleccionUsuario);
            System.out.println("Elección de la computadora: " + eleccionComputadora);

            // Mostrar el resultado
            jugadaUsuario.comparar(jugadaComputadora);

            continuar = preguntarSiQueremosContinuar();
        }// end while

        System.out.println("¡Hasta pronto!");
        scanner.close();
    }

    private Jugada obtenerJugada(String eleccionUsuario) {
        if(eleccionUsuario.equals("piedra")) {
            return new Piedra();
        } else if(eleccionUsuario.equals("papel")) {
            return new Papel();
        } else if(eleccionUsuario.equals("tijera")) {
            return new Tijera();
        } else {
            throw new IllegalArgumentException("Opción no válida: " + eleccionUsuario);
        }
    }

    private String elegirElementoUsuario(Scanner scanner) {
        // Solicitar al usuario que ingrese su elección
        System.out.println("Elige una opción: piedra, papel o tijera");
        String eleccion = scanner.nextLine().toLowerCase();
        return eleccion;
    }

    private String elegirElementoComputadora(String[] opciones) {
        // Crear un objeto Random para generar la elección de la computadora
        Random random = new Random();
        // Generar la elección de la computadora
        int indice = random.nextInt(3);
        return opciones[indice];
    }

    private boolean preguntarSiQueremosContinuar() {
        System.out.println("¿Desea continuar? s/n");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();
        return respuesta.toLowerCase().charAt(0) == 's';
    }
}
