import java.util.Scanner;

/**
 * Es nuestra clase principal en donde muestra un menú para realizar varias operaciones, depende cual elijas:
 * calcular IMC, area de un rectangulo, conversian de °C a °F y area de un circulo.
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Menu");
            System.out.println("1.Calcular IMC");
            System.out.println("2.Calcular area de un rectangulo");
            System.out.println("3.Convertir °C a °F");
            System.out.println("4.Calcular area de un circulo");
            System.out.println("5.Salir");
            System.out.print("Ingresa la opcion que necesites: ");

            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    calcularIMC();
                    break;
                case 2:
                    calcularAreaRectangulo();
                    break;
                case 3:
                    convertirCelsiusAFahrenheit();
                    break;
                case 4:
                    calcularAreaCirculo();
                    break;
                case 5:
                    System.out.println("Se esta saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion no correcta, intenta de nuevo.");
            }
            System.out.println();

        } while (choice != 5);
    }

    /**
     * Calcula el Indice de Masa Corporal dependiendo de el peso y la estatura del usuario.
     * @param peso en kilogramos
     * @param estatura en metros
     * @return IMC calculado
     */
    public static double calcularIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    /**
     * Metodo para pedir datos al usuario y calcular el IMC.
     */
    public static void calcularIMC() {
        System.out.print("Ingrese su peso en kilogramos: ");
        double peso = scanner.nextDouble();
        System.out.print("Ingrese su estatura en metros: ");
        double estatura = scanner.nextDouble();

        double imc = calcularIMC(peso, estatura);
        System.out.printf("Su IMC es: %.2f%n", imc);
    }

    /**
     * Calcula el area de un rectangulo.
     * @param base del rectangulo
     * @param altura del rectangulo
     * @return área del rectangulo
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Metodo para pedir datos al usuario y calcular el area de un rectangulo.
     */
    public static void calcularAreaRectangulo() {
        System.out.print("Ingrese la base del rectangulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del rectangulo: ");
        double altura = scanner.nextDouble();

        double area = calcularAreaRectangulo(base, altura);
        System.out.printf("El área del rectangulo es: %.2f%n", area);
    }

    /**
     * Convierte grados Celsius a Fahrenheit.
     * @param celsius temperatura en °C
     * @return temperatura en °F
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Metodo para pedir temperatura al usuario y mostrar la conversion a °F.
     */
    public static void convertirCelsiusAFahrenheit() {
        System.out.print("Ingrese la temperatura en °C: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = convertirCelsiusAFahrenheit(celsius);
        System.out.printf("%.2f °C equivalen a %.2f °F%n", celsius, fahrenheit);
    }

    /**
     * Calcula el area de un círculo.
     * @param radio del circulo
     * @return área del circulo
     */
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    /**
     * Metodo para pedir el radio al usuario y calcular el area del circulo.
     */
    public static void calcularAreaCirculo() {
        System.out.print("Ingrese el radio del circulo: ");
        double radio = scanner.nextDouble();

        double area = calcularAreaCirculo(radio);
        System.out.printf("El area del circulo es: %.2f%n", area);
    }
}