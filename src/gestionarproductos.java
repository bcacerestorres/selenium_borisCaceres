import java.util.Scanner;
public class gestionarproductos {
    public static void main(String args[]) {
        // Pedir los datos del producto
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------Datos para los articulos----------------------------------");
        System.out.println("Ingrese el nombre del producto 1 :  ");
        String nombreProd1 = input.nextLine();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Ingrese el codigo del producto 1 ");
        int codigoProd1 = input.nextInt();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Ingrese true o false si el producto 1 es importado :  ");
        boolean importadoProd1 = input.nextBoolean();
        System.out.println("------------------------------------------------------------------------------------");
        //limpiar buffer
        input.nextLine();

        System.out.println("Ingrese el lote del producto 1 :  ");
        String nloteProd1 = input.nextLine();
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("Ingrese el nombre del producto 2 :  ");
        String nombreProd2 = input.nextLine();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Ingrese el codigo del producto 2 ");
        int codigoProd2 = input.nextInt();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Ingrese true o false si el producto 2 es importado :  ");
        boolean importadoProd2 = input.nextBoolean();

        // limpiar buffer
        input.nextLine();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Ingrese el lote del producto 2  ");
        String loteProd2 = input.nextLine();
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("Ingrese el nombre del producto 3 :  ");
        String nombreProd3 = input.nextLine();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Ingrese el codigo del producto 3 ");
        int codigoProd3 = input.nextInt();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Ingrese true o false si el producto 3 es importado :  ");
        boolean importadoProd3 = input.nextBoolean();

        // limpiar buffer
        input.nextLine();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Ingrese el lote del producto 3  ");
        String loteProd3 = input.nextLine();

        // cerrrar lectura
        input.close();

        // mostrar productos en pantalla
        producto  prod1= new producto(nombreProd1,codigoProd1,importadoProd1,nloteProd1);
        System.out.println("--------------------------Resumen del producto 1--------------------------------------");
        System.out.println(prod1);
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("--------------------------Resumen del producto 2--------------------------------------");
         producto  prod2= new producto(nombreProd2,codigoProd2,importadoProd2,loteProd2);
        System.out.println(prod2);
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("--------------------------Resumen del producto 3--------------------------------------");
        producto  prod3= new producto(nombreProd3,codigoProd3,importadoProd3,loteProd3);
        System.out.println(prod3);
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("--------------------------Resumen del producto 4--------------------------------------");
        producto  prod4= new producto();
        System.out.println(prod4);
        System.out.println("-------------------------------------------------------------------------------------");

    }

}
