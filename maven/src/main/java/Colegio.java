import java.util.ArrayList;
import java.util.Scanner;
public class Colegio {
    public static void main (String args[]) {
// definicion de un lista de empleados
        ArrayList<Persona> listaPersona = new ArrayList<Persona>();
        //metodo de lectura de teclado
        Scanner input = new Scanner(System.in);
        // pequeño menu
        int opcion = 0;
        System.out.println("*** BIENVENIDOS *****");
        while (opcion != 4){
            System.out.println("1- Agregar Profesor");
            System.out.println("2- Agregar Alumno");
            System.out.println("3- Ver alumnos y profesores");
            System.out.println("4- Salir");
            System.out.println("********************");
            opcion = input.nextInt();


            if (opcion == 1) {
                // ingreso profesor
                System.out.println("Ingrese el nombre del profesor");
                String nombre = input.next();
                Persona profe = new Profesor(nombre,"233363-7",45,"arte",12000000);
                listaPersona.add(profe);
            } else if (opcion == 2) {
                // ingreso de alumno
                System.out.println("Ingrese el nombre del alumno");
                String nombre = input.next();
                Persona alum = new Alumno(nombre,"1633366-k",13,6);
                listaPersona.add(alum);

            }else if(opcion ==3){
                // imprimir alumnos
                imprimirPersona(listaPersona);

            } else {
                System.out.println("Saliendo");
            }
            System.out.println("****************");
        }

    }

    // metodo de impresion persona
    private static void imprimirPersona(ArrayList<Persona> listaPersona){
        System.out.println("******* LISTA DE PERSONA *******");
        if (listaPersona.isEmpty()) {
            System.out.println("No hay persona en el sistema");
        } else {
            for (Persona unPersonaDelSistema : listaPersona ){
                System.out.println(unPersonaDelSistema);
            }
        }
    }


}// fin clase
