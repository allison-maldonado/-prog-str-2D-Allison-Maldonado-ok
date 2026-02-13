//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HMain {
    public static void main(String[] args) {

        //Herencia
        Perro dogo= new Perro("Dogo");
        Gato rawrl= new Gato("Rawrl");

        dogo.comer();
        dogo.hacerSonido();
        dogo.marcarTerritorio();

        rawrl.comer();
        rawrl.hacerSonido();
        System.out.println("..............");
        //Polimorfismo
        Animal[] animales = new Animal[3];
        animales[0] = new Perro("Ramonchis");
        animales[1] = new Gato("Salem");
        animales[2] = new Perro("Firulais");
        for(Animal animal : animales){
            animal.hacerSonido();
        }
        System.out.println("...............");
        Animal miercoles = new Perro("Miercoles");

        if(miercoles instanceof Perro){
            Perro miercoles1= (Perro) miercoles;
            miercoles1.marcarTerritorio();
        }
    }
}