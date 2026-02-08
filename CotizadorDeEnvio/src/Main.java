import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double pesoKg = InputValidator.leerDoubleEnRango(sc,"Ingresa el peso en kg (0.1 a 50): ", 0.1, 50.0);

        int distanciaKm = InputValidator.leerIntEnRango(sc,"Ingresa la distancia en km (1 a 2000): ", 1, 2000);

        int tipoServicio = InputValidator.leerIntEnRango(sc,"Tipo de servicio (1 = Estandar, 2 = Express): ", 1, 2);

        boolean esZonaRemota = InputValidator.leerBoolean(sc,"¿Es zona remota? (true/false): ");

        ShippingCalculator calc = new ShippingCalculator();

        double subtotal = calc.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        Ticket.imprimirTicket(tipoServicio, pesoKg, distanciaKm,esZonaRemota, subtotal, iva, total);

        sc.close();
    }
}
