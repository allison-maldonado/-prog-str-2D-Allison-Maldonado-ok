import java.util.Scanner;

public class PersonaService {

    public void alta(Scanner sc, Persona[] personas) {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (id <= 0) {
            System.out.println("El ID debe ser mayor a 0");
            return;
        }
        if (existeId(personas, id)) {
            System.out.println("El ID ya existe");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacio");
            return;
        }
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, nombre);
                System.out.println("Persona registrada");
                return;
            }
        }
        System.out.println("Arreglo lleno");
    }
    public void buscar(Scanner sc, Persona[] personas) {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                System.out.println("ID: " + p.getId());
                System.out.println("Nombre: " + p.getNombre());
                return;
            }
        }
        System.out.println("No encontrada o inactiva");
    }
    public void baja(Scanner sc, Persona[] personas) {
        System.out.print("ID a dar de baja: ");
        int id = sc.nextInt();
        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                p.setActiva(false);
                System.out.println("Baja realizada");
                return;
            }
        }
        System.out.println("No encontrada o ya inactiva");
    }
    public void listar(Persona[] personas) {
        for (Persona p : personas) {
            if (p != null && p.isActiva()) {
                System.out.println(p.getId() + " - " + p.getNombre());
            }
        }
    }
    public void actualizar(Scanner sc, Persona[] personas) {
        System.out.print("ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                System.out.print("Nuevo nombre: ");
                String nuevo = sc.nextLine();
                if (nuevo.trim().isEmpty()) {
                    System.out.println("Nombre invalido");
                    return;
                }
                p.setNombre(nuevo);
                System.out.println("Nombre actualizado");
                return;
            }
        }
        System.out.println("No encontrada o inactiva");
    }
    private boolean existeId(Persona[] personas, int id) {
        for (Persona p : personas) {
            if (p != null && p.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
