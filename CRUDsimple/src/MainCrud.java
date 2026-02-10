import java.util.Scanner;

public class MainCrud {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        PersonaService service = new PersonaService();
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Baja logica");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre");
            System.out.println("0) Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> service.alta(sc, personas);
                case 2 -> service.buscar(sc, personas);
                case 3 -> service.baja(sc, personas);
                case 4 -> service.listar(personas);
                case 5 -> service.actualizar(sc, personas);
                case 0 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }
}


