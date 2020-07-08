import java.util.Scanner;
public class Automotora {
    public static void main(String args[]){
        //llamando al constructor sin parametro
        Camion c1 = new Camion();
        //llamando al constructor con chapa
        Camion c2 = new Camion(12336);
        //llamando al constructor con chapa y color
        Camion c3 = new Camion(23286,"Amarillo");
       // Mostrar los datos en pantalla de cada camión
        System.out.println("-----------------------Datos de otros camiones----------------------------------");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

       // Pedir los datos de un camión al usuario
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------Datos del Camion----------------------------------");
        System.out.println("Ingrese el color del camion  ");
        String colorCamion = input.nextLine();

        System.out.println("Ingrese la chapa del camion ");
        int chapaCamion = input.nextInt();

        System.out.println("Ingrese el año del camion  ");
        int añoCamion = input.nextInt();

        Camion c4 = new Camion(chapaCamion, colorCamion,añoCamion);
        System.out.println("---------------------------------------------------------------------------");
        //
        boolean revision = c4.leTocaRevision(añoCamion);
        if (revision == true) {
            System.out.println("Al camion le toca revision");
        } else {
            System.out.println("Al camion no le toca revision");
        }

    }
}
