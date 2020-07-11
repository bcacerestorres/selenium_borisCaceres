import java.util.Scanner;
public class Librería {
    public static void main(String args[]){
        // Pedir los datos al usuario
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------Datos del libros 1----------------------------------");
        System.out.println("Ingrese el titulo del libro 1   ");
        String  libro1Titulo= input.nextLine();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Ingrese el autor del libro 1   ");
        String  libro1Autor= input.nextLine();
        System.out.println("------------------------------------------------------------------------------------");

        // limpia el buffer
        //  input.nextLine();

        System.out.println("Ingrese el isbn del libro 1  ");
        int libro1ISBN = input.nextInt();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Ingrese el numero de paginas del libro 1  ");
        int libro1Paginas = input.nextInt();
        System.out.println("------------------------------------------------------------------------------------");

        // limpiar buffer
        input.nextLine();

        System.out.println("-------------------------------Datos del libro 2-----------------------------------------------------");
        System.out.println("Ingrese el titulo del libro 2   ");
        String  libro2Titulo= input.nextLine();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Ingrese el autor del libro 2   ");
        String  libro2Autor= input.nextLine();
        System.out.println("------------------------------------------------------------------------------------");

        // limpiar en buffer
        // input.nextLine();

        System.out.println("Ingrese el isbn del libro 2  ");
        int libro2ISBN = input.nextInt();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Ingrese el numero de paginas del libro 2  ");
        int libro2Paginas = input.nextInt();
        System.out.println("------------------------------------------------------------------------------------");

        // cerrar lectura
        input.close();

        // mostrar libros en pantalla
        Libro  libro1= new Libro(libro1ISBN,libro1Titulo,libro1Autor,libro1Paginas);
        System.out.println("--------------------------Resumen del libro 1--------------------------------------");
        System.out.println(libro1);
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("--------------------------Resumen del libro 2--------------------------------------");
         Libro libro2= new Libro(libro2ISBN,libro2Titulo,libro2Autor,libro2Paginas);
         System.out.println(libro2);
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("--------------------------Resumen del libro 3--------------------------------------");
        Libro  libro3= new Libro();
        System.out.println(libro3);
        System.out.println("-------------------------------------------------------------------------------------");
    }
    //
}
