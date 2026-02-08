public class Ticket {

    public static void imprimirTicket(int tipoServicio, double pesoKg, int distanciaKm,boolean zonaRemota, double subtotal, double iva, double total) {

        String servicio;
        if (tipoServicio == 1) {
            servicio = "Estandar";
        } else {
            servicio = "Express";
        }

        System.out.println("Ticket de envio");
        System.out.println("Servicio: " + servicio);
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Zona remota: " + zonaRemota);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA: $" + iva);
        System.out.println("Total final a pagar: $" + total);
    }
}
