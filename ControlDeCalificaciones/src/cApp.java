import java.util.Scanner;

public class cApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nuestro input
        String nombre = leerTextoNoVacio(sc, "Ingresa el nombre del alumno: ");
        double califp1 = leerDoubleEnRango(sc, "Parcial 1 (0 a 100): ", 0, 100);
        double califp2 = leerDoubleEnRango(sc, "Parcial 2 (0 a 100): ", 0, 100);
        double califp3 = leerDoubleEnRango(sc, "Parcial 3 (0 a 100): ", 0, 100);
        int asistencia = leerIntEnRango(sc, "Asistencia (0 a 100): ", 0, 100);
        boolean entregaProyecto = leerBoolean(sc, "¿Entrego proyecto? (true/false): ");

        // Aqui esta nuestro proceso, en donde se manda a la otra clase
        GradeService service = new GradeService();
        double promedio = service.calcularPromedio(califp1, califp2, califp3);
        double finalCal = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(finalCal, asistencia, entregaProyecto);

        // Aqui esta nuestro output
        imprimirReporte(nombre, califp1, califp2, califp3, promedio, asistencia, entregaProyecto, finalCal, estado);
        sc.close();
    }

    // Los metodos de nuestro input
    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine();
        } while (texto.trim().isEmpty());
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        boolean valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                break;
            } else {
                sc.next();
            }
        }
        return valor;
    }

    // Nuestro output

    public static void imprimirReporte(String nombre, double califp1, double califp2, double califp3, double promedio, int asistencia,
                                       boolean entregaProyecto, double finalCal, String estado) {

        System.out.println("El reporte final");
        System.out.println("Nombre del alumno: " + nombre);
        System.out.println("Parciales: " + califp1 + ", " + califp2 + ", " + califp3);
        System.out.println("Promedio parciales: " + promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entrego proyecto: " + entregaProyecto);
        System.out.println("Calificacion final: " + finalCal);
        System.out.println("Estado: " + estado);
    }
}
