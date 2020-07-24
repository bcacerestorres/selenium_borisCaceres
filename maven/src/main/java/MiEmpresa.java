import java.util.ArrayList;
import java.util.Scanner;
public class MiEmpresa {
    public static void main (String args[]) {
        // definicion de un lista de empleados
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        //metodo de lectura de teclado
        Scanner input = new Scanner(System.in);
        // pequeño menu
        int opcion = 0;
        System.out.println("*** BIENVENIDOS *****");
        while (opcion != 5){
            System.out.println("1- Ingresar Tester");
            System.out.println("2- Ingresar Desarrollador");
            System.out.println("3- Ingresar un Manager");
            System.out.println("4- Ver Empleados");
            System.out.println("5- Salir");
            opcion = input.nextInt();

            if (opcion == 1) {
                // ingreso tester
                System.out.println("Ingrese el nombre del tester");
                String nombre = input.next();
                Empleado tester = new Tester(nombre, 1234123, 123412,true, false);
                listaEmpleados.add(tester);
            } else if (opcion == 2) {
                // ingreso de desarrollador
                System.out.println("Ingrese el nombre del desarrollador");
                String nombre = input.next();
                Empleado dev = new Developer(nombre,123123,199999,"Phyton");
                listaEmpleados.add(dev);
            }else if(opcion ==3){
                // manager
                System.out.println("Ingrese el manager");
                String nombre = input.next();
                Empleado maneger = new Manager(nombre,93633003,25000000,"Desarrollo");
                listaEmpleados.add(maneger);
            } else if (opcion == 4) {
                imprimirEmpleados(listaEmpleados);
            } else {
                System.out.println("Saliendo");
            }
            System.out.println("****************");
        }
    } // fin main

    // metodo de impresion empleados
    private static void imprimirEmpleados(ArrayList<Empleado> listaEmpleados){
        System.out.println("******* LISTA DE EMPLEADOS *******");
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados en el sistema");
        } else {
            for (Empleado unEmpleadoDelSistema : listaEmpleados ){
                System.out.println(unEmpleadoDelSistema);
            }
        }
    }


}//fin de la clase
