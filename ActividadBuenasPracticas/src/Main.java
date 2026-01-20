import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Pedimos el número al usuario
        int numero = pedirNumero();

        // Hacemos la suma
        int suma = sumarHasta(numero);

        // Mostramos el resultado final
        System.out.println("La suma de los números del 1 al " + numero + " es: " + suma);
    }

    // Metodo para pedir un número
    public static int pedirNumero() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe un número entero: ");
        int num = sc.nextInt();
        return num;
    }

    // Metodo para sumar del 1 hasta el número que pusiste
    public static int sumarHasta(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        return suma;
    }
}

