import java.util.Scanner;

public class MainAlumnos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[25];
        int opcion;

        do {
            System.out.println("MENU");
            System.out.println("1 Alta alumno");
            System.out.println("2 Buscar por ID (solo activos)");
            System.out.println("3 Actualizar promedio");
            System.out.println("4 Baja logica por ID");
            System.out.println("5 Listar activos");
            System.out.println("6 Reportes");
            System.out.println("0 Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (id <= 0) {
                        System.out.println("El ID debe ser mayor que 0");
                        break;
                    }

                    // Verificar que nuestro ID no este repetido
                    boolean repetido = false;
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].id == id) {
                            repetido = true;
                        }
                    }

                    if (repetido) {
                        System.out.println("Ese ID ya esta registrado");
                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    if (nombre.trim().isEmpty()) {
                        System.out.println("El nombre no puede estar vacio");
                        break;
                    }

                    System.out.print("Promedio (0 a 10): ");
                    double promedio = sc.nextDouble();

                    if (promedio < 0 || promedio > 10) {
                        System.out.println("El promedio debe estar entre 0 y 10");
                        break;
                    }

                    // Se guarda en el primer espacio libre
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] == null) {
                            alumnos[i] = new Alumno(id, nombre, promedio);
                            System.out.println("Alumno agregado correctamente");
                            break;
                        }
                    }

                    break;

                case 2:

                    System.out.print("ID a buscar: ");
                    int buscar = sc.nextInt();

                    boolean encontrado = false;

                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].id == buscar && alumnos[i].activo) {

                            System.out.println("ID: " + alumnos[i].id);
                            System.out.println("Nombre: " + alumnos[i].nombre);
                            System.out.println("Promedio: " + alumnos[i].promedio);

                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontro o esta inactivo");
                    }

                    break;

                case 3:

                    System.out.print("ID: ");
                    int idActualizar = sc.nextInt();

                    boolean encontrado2 = false;

                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].id == idActualizar && alumnos[i].activo) {

                            encontrado2 = true;

                            System.out.print("Nuevo promedio: ");
                            double nuevo = sc.nextDouble();

                            if (nuevo >= 0 && nuevo <= 10) {
                                alumnos[i].promedio = nuevo;
                                System.out.println("Promedio cambiado");
                            } else {
                                System.out.println("Promedio incorrecto");
                            }
                        }
                    }

                    if (!encontrado2) {
                        System.out.println("No se encontro el alumno");
                    }

                    break;

                case 4:

                    System.out.print("ID: ");
                    int idBaja = sc.nextInt();

                    boolean encontrado3 = false;

                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].id == idBaja && alumnos[i].activo) {
                            alumnos[i].activo = false;
                            System.out.println("Alumno dado de baja");
                            encontrado3 = true;
                        }
                    }

                    if (!encontrado3) {
                        System.out.println("No se encontro el alumno");
                    }

                    break;

                case 5:

                    // Nos muestra solo los activos
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].activo) {
                            System.out.println("ID: " + alumnos[i].id +
                                    " Nombre: " + alumnos[i].nombre +
                                    " Promedio: " + alumnos[i].promedio);
                        }
                    }

                    break;

                case 6:

                    double suma = 0;
                    int contador = 0;
                    int contadorAltos = 0;

                    Alumno mayor = null;
                    Alumno menor = null;

                    for (int i = 0; i < alumnos.length; i++) {

                        if (alumnos[i] != null && alumnos[i].activo) {

                            suma = suma + alumnos[i].promedio;
                            contador++;

                            if (mayor == null || alumnos[i].promedio > mayor.promedio) {
                                mayor = alumnos[i];
                            }

                            if (menor == null || alumnos[i].promedio < menor.promedio) {
                                menor = alumnos[i];
                            }

                            if (alumnos[i].promedio >= 8.0) {
                                contadorAltos++;
                            }
                        }
                    }

                    if (contador == 0) {
                        System.out.println("No hay alumnos activos");
                    } else {

                        double promedioGeneral = suma / contador;

                        System.out.println("Promedio general: " + promedioGeneral);

                        System.out.println("Alumno con mayor promedio:");
                        System.out.println("ID: " + mayor.id);
                        System.out.println("Nombre: " + mayor.nombre);
                        System.out.println("Promedio: " + mayor.promedio);
                        System.out.println("--------------------------- ");
                        System.out.println("Alumno con menor promedio:");
                        System.out.println("ID: " + menor.id);
                        System.out.println("Nombre: " + menor.nombre);
                        System.out.println("Promedio: " + menor.promedio);
                        System.out.println("--------------------------- ");
                        System.out.println("Alumnos con promedio >= 8: " + contadorAltos);
                    }

                    break;

                case 0:
                    System.out.println("Programa terminado");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
    }
}
