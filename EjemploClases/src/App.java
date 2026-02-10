import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

//I-P-O
        Scanner sc= new Scanner(System.in);
        InputDataValidator inputDataValidator = new InputDataValidator();
        Ticket1 ticket1 = new Ticket1();//Creacion de objeto de la clase Ticket

//Input
        int cantidad= inputDataValidator.getValidInt(sc, "Ingresa la cantidad de productos");
//Process
        ticket1.process(cantidad);
//Output
        ticket1.imprimirTicket(cantidad);



    }
}