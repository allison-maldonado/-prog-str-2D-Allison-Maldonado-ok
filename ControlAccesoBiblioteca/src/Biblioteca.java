import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalValidos = 0;
        int totalPermitidos = 0;
        int totalDenegados = 0;

        while (true) {

            System.out.print("Codigo de usuario: ");
            String codigo = scanner.nextLine();

            if (codigo.equals("SALIR")) {
                break;
            }

            // Validar código
            if (!esCodigoValido(codigo)) {
                System.out.println("Codigo invalido");
                continue;
            }

            totalValidos++;

            // Validar tipo de usuario
            System.out.print("Tipo de usuario (true=alumno, false=externo): ");

            if (!scanner.hasNextBoolean()) {
                System.out.println("Tipo invalido");
                return;
            }

            boolean esAlumno = scanner.nextBoolean();

            // Validar hora
            System.out.print("Hora de entrada (0-23): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Hora invalida");
                return;
            }

            int hora = scanner.nextInt();

            scanner.nextLine(); // limpiar buffer

            if (hora < 0 || hora > 23) {
                System.out.println("Hora invalida");
                return;
            }

            // Biblioteca cerrada
            if (hora >= 21) {
                System.out.println("Biblioteca cerrada");
                break;
            }

            // Verificar horario permitido
            if (esHorarioPermitido(hora, esAlumno)) {
                System.out.println("Acceso permitido");
                totalPermitidos++;
            } else {
                System.out.println("Acceso denegado");
                totalDenegados++;
            }
        }

        // Resultados finales
        System.out.println("\n--- Resumen ---");
        System.out.println("Total registros validos: " + totalValidos);
        System.out.println("Total permitidos: " + totalPermitidos);
        System.out.println("Total denegados: " + totalDenegados);

        double porcentaje = 0;
        if (totalValidos > 0) {
            porcentaje = (double) totalPermitidos / totalValidos * 100;
        }

        System.out.printf("Porcentaje permitidos: %.2f%%\n", porcentaje);
    }

    static boolean esCodigoValido(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            return false;
        }

        if (codigo.length() != 6) {
            return false;
        }

        for (int i = 0; i < codigo.length(); i++) {
            if (!Character.isLetterOrDigit(codigo.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    static boolean esHorarioPermitido(int hora, boolean esAlumno) {

        if (esAlumno) {
            return hora >= 8 && hora <= 20;
        } else {
            return hora >= 10 && hora <= 18;
        }
    }
}
