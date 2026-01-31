import java.util.Scanner;

public class MainConversion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        int cyf = 0;
        int fyc = 0;
        int kmym = 0;
        int myk = 0;

        do {
            System.out.println("Nuestro menu de conversiones");
            System.out.print("Elige una opción: \n");
            System.out.println("1.- °C a °F");
            System.out.println("2.- °F a °C");
            System.out.println("3.- Km a Millas");
            System.out.println("4.- Millas a Km");
            System.out.println("5.- Salir");

            if (!sc.hasNextInt()) {
                System.out.println("Opción inválida. Debes ingresar un número.");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción fuera de rango. Intenta de nuevo.");
                continue;
            }

            if (opcion == 5) {
                break;
            }

            System.out.print("Ingresa el valor a convertir: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Dato no numérico. Intenta otra vez.");
                sc.next();
                continue;
            }

            double valor = sc.nextDouble();
            double resultado;

            switch (opcion) {
                case 1:
                    resultado = (valor * 9 / 5) + 32;
                    System.out.println(valor + " °C = " + resultado + " °F");
                    cyf++;
                    break;

                case 2:
                    resultado = (valor - 32) * 5 / 9;
                    System.out.println(valor + " °F = " + resultado + " °C");
                    fyc++;
                    break;

                case 3:
                    resultado = valor * 0.621371;
                    System.out.println(valor + " Km = " + resultado + " Millas");
                    kmym++;
                    break;

                case 4:
                    resultado = valor * 1.60934;
                    System.out.println(valor + " Millas = " + resultado + " Km");
                    myk++;
                    break;
            }

        } while (true);

        int total = cyf + fyc + kmym + myk;

        System.out.println("Total de conversiones: " + total);
        System.out.println("°C a °F: " + cyf);
        System.out.println("°F a °C: " + fyc);
        System.out.println("Km a Millas: " + kmym);
        System.out.println("Millas a Km: " + myk);
        System.out.println("Programa finalizado.");

        sc.close();
    }
}
