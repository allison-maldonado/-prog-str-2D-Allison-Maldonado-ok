import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Se muestra nuestro menu
        System.out.println("Menu de operaciones:");
        System.out.println("1:Sumar");
        System.out.println("2:Restar");
        System.out.println("3:Multiplicar");
        System.out.println("4:Dividir");

        // Nuestro programa pide que elijas una opcion
        System.out.print("Elige una opcion: ");
        int opcion = sc.nextInt();

        // Pide los valores para las operaciones
        System.out.print("Ingresa el valor de a: ");
        double a = sc.nextDouble();

        System.out.print("Ingresa el valor de b: ");
        double b = sc.nextDouble();

        double resultado;

        // Segun la opcion que se eligio se realizara la operacion
        switch (opcion) {

            case 1:
                resultado = a + b;
                System.out.println("Operacion elegida: Sumar");
                System.out.println("Valores: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                resultado = a - b;
                System.out.println("Operacion elegida: Restar");
                System.out.println("Valores: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                resultado = a * b;
                System.out.println("Operacion elegida: Multiplicar");
                System.out.println("Valores: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                if (b == 0) {
                    System.out.println("Operacion elegida: Dividir");
                    System.out.println("Valores: a = " + a + ", b = " + b);
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                    System.out.println("Operacion elegida: Dividir");
                    System.out.println("Valores: a = " + a + ", b = " + b);
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }

        sc.close();
    }
}
