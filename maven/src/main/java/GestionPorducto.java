import java.util.ArrayList;
import java.util.Scanner;
public class GestionPorducto {
    public static void main (String args[]) {
        ArrayList<Productos> listaProdcutos = new ArrayList<Productos>();
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        System.out.println("*** BIENVENIDOS *****");
        while (opcion != 4){
            System.out.println("1- Ingresar un producto perecedero");
            System.out.println("2- Ingresar un producto no percedero");
            System.out.println("3- Ver producto");
            System.out.println("4- Salir");
            System.out.println("****************");
            opcion = input.nextInt();

            if (opcion == 1) {
                System.out.println("Ingrese el nombre del producto de percedero");
                String nombre = input.next();
                Productos percedero = new Perecedero(nombre,15000,2);
                listaProdcutos.add(percedero);
            } else if (opcion == 2) {
                System.out.println("Ingrese el nombre del producto no percedero");
                String nombre = input.next();
                Productos nopercedero = new Noperecedero(nombre,140000," conserva");
                listaProdcutos.add(nopercedero);
            }else if(opcion ==3){
                imprimirProductos(listaProdcutos);
            }  else {
                System.out.println("Saliendo");
            }
            System.out.println("****************");
        }

    }


    private static void imprimirProductos(ArrayList<Productos> listaProductos){
        System.out.println("******* LISTA DE productos *******");
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos en el sistema");
        } else {
            for (Productos unProdcutoDelSistema : listaProductos ){
                System.out.println(unProdcutoDelSistema);
            }
        }
    }


}
