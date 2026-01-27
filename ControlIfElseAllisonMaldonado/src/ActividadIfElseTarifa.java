import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Pide al usuario su edad
        System.out.print("Ingresa tu edad por favor: ");
        int edad = scanner.nextInt();

        // Valida si tu edad es menor a 0 o mayor a 120
        if (edad < 0 || edad > 120) {
            System.out.println("Tu edad es inválida");
            return; // termina el programa si cumple con la condicion
        }

        // le pide al usuario si es estudiante
        System.out.print("¿Eres estudiante? (true/false): ");
        boolean esEstudiante = scanner.nextBoolean();

        int tarifa;

        // Reglas o condiciones de tarifa
        if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else { // edad >= 18
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        // Resultados finales de todas las peticiones
        System.out.println(" RESULTADO ");
        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Tarifa final: $" + tarifa);

        scanner.close();
    }
}
