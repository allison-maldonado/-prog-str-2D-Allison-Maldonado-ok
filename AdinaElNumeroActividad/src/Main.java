import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int max = 100;
        int min = 1;
        int secreto = random.nextInt(100) + 1; // Genera un int (numero) del 1 al 100
        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;
        int fueraDeRango = 0;
        int noNumerico = 0;

        System.out.println("Adivina el numero secreto (1-100)");

        while (intentos < limiteIntentos) {
            System.out.println("Intento " + (intentos + 1) + " de " + limiteIntentos);

            if (sc.hasNextInt()) {
                int numero = sc.nextInt();

                if (numero < min || numero > max) {
                    System.out.println("Numero fuera de rango (1-100)");
                    fueraDeRango++;
                    continue; // No cuenta como intento
                }
                intentos++;

                if (numero == secreto) {
                    System.out.println("¡Ganaste!");
                    gano = true;// Para saber si el usuario gano o no
                    break;
                } else if (numero > secreto) {
                    System.out.println("El numero que estas buscando es menor a: " + numero);

                } else {
                    System.out.println("El numero que estas buscando es mayor a: " + numero);


                }

            } else {
                System.out.println("Entrada no numerica, intenta otra vez");
                sc.next(); // Para limpiar el token de entrada (terminal)
                noNumerico++;
            }
        }

        if (!gano) {
            System.out.println("Perdiste :( , el numero secreto era: " + secreto);
        }
        System.out.println("Intentos usados: " + intentos);
        System.out.println("Entradas fuera de rango: " + fueraDeRango);
        System.out.println("Entradas no numéricas: " + noNumerico);
    }
}
