import java.util.ArrayList;
import java.util.Scanner;

public class EjerciciosListas {
  // metodo main
    public static void main(String[] args) {
        // declaracion
        ArrayList<String> listaNombres = new ArrayList<String>();
        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
        ArrayList<Boolean> listaBooleano = new ArrayList<Boolean>();

        // llenar lista string nombres
        listaNombres.add("Andres"); //pos0
        listaNombres.add("Maria"); // pos1
        listaNombres.add("Jose"); //pos2
        imprimirLista(listaNombres);

        System.out.println("-----------------------------------------------------------------------------");
        listaNumeros.add(2);
        listaNumeros.add(4);
        listaNumeros.add(10);
        imprimirListaEnteros(listaNumeros);
        System.out.println("la cantidad de elementos :"+cantidadElementos(listaNumeros));
        System.out.println("la lista esta vacia  "+esListaEnterosVacia(listaNumeros));
        System.out.println("la suma  : "+obtenerSumaTotal(listaNumeros));
        System.out.println("el promedio es   : "+calcularPromedio(listaNumeros));
        System.out.println("el menor es   : "+obtenerMenor(listaNumeros));
        System.out.println("el mayor es   : "+obtenerMayor(listaNumeros));

        System.out.println("-----------------------------------------------------------------------------");
        listaBooleano.add(true); //pos0
        listaBooleano.add(false); // pos1
        listaBooleano.add(true); //pos2
        listaBooleano.add(true);
        System.out.println(" la lista de booleano "+esTrue(listaBooleano));
        System.out.println("-----------------------------------------------------------------------------");
        leerValores();
    }

    //Crear un método imprimirListaEnteros que reciba una lista de enteros, y los imprima en pantalla.
    public static void imprimirListaEnteros(ArrayList<Integer> listaEnteros) {
        System.out.println("Voy a imprimir los elementos de la lista: ");
        for (int i = 0; i < listaEnteros.size(); i++) {
            System.out.println(listaEnteros.get(i));
        }
    }

    //Crear un método imprimirListaStrings que reciba una lista de Strings, y los imprima en pantalla.
    public static void imprimirLista(ArrayList<String> listaStrings) {
        System.out.println("Voy a imprimir los elementos de la lista: ");
        for (int i = 0; i < listaStrings.size(); i++) {
            System.out.println(listaStrings.get(i));
        }
    }

    //Método que reciba una lista de enteros, y retorne la cantidad de elementos de la misma.
    public static int cantidadElementos (ArrayList<Integer> listaEnteros) {
        return listaEnteros.size();
    }

    //Método que reciba una lista de enteros, y retorne la verdadero si y sólo si la lista está vacía.
    public static boolean esListaEnterosVacia (ArrayList<Integer> listaEnteros) {

        if (listaEnteros.isEmpty() == true) {
            return true;
        } else {
            return false;
        }
    }

   // Método que reciba una lista de enteros, y retorne la suma.
   public static int obtenerSumaTotal (ArrayList<Integer> listaEnteros) {
       int suma = 0;
       for (int i = 0; i < listaEnteros.size(); i++) {
           suma = suma + listaEnteros.get(i);
       }
       return suma;
   }

   // Método que reciba una lista de enteros, y retorne el promedio de los mismos.
   public static float calcularPromedio(ArrayList<Integer> listaNumeros) {
       int sumaTotal = obtenerSumaTotal(listaNumeros);
       float promedio = sumaTotal / listaNumeros.size();
       return promedio;
   }

   // Método que reciba una lista de enteros, y retorne el menor.
   public static int obtenerMenor (ArrayList<Integer> listaNumeros) {
       int min = Integer.MAX_VALUE;

       for (int i = 0; i < listaNumeros.size(); i++) {
           if (listaNumeros.get(i) < min) {
               min = listaNumeros.get(i);
           }
       }

       return min;
   }

   // Método que reciba una lista de enteros, y retorne el mayor.
   public static int obtenerMayor (ArrayList<Integer> listaNumeros) {
       int max = Integer.MIN_VALUE;

       for (int i = 0; i < listaNumeros.size(); i++) {
           if (listaNumeros.get(i) > max) {
               max = listaNumeros.get(i);
           }
       }

       return max;
   }

    //Método que reciba una lista de booleanos, y verdadero si y sólo si,
    // todos los elementos de la lista son true. De lo contrario se debe retornar false.
    // Sugerencia: utilizar cortocircuito.
public static boolean esTrue(ArrayList<Boolean> listaboolean){
    for (int i = 0; i < listaboolean.size(); i++) {
        if (listaboolean.get(i) == false) {
            return false;
        }
       }
    return true;
    }

    //Método leerValores(): pide por teclado los números y los almacena en el ArrayList.
    // La lectura acaba cuando se introduce el valor -99. El método devuelve mediante
    // return el ArrayList con los valores introducidos.
public static  ArrayList<Integer> leerValores(){
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
    int num =0;
    while (num != -99){
        System.out.println("Ingrese un valor numerico :");
        num =input.nextInt();
        listaNumeros.add(num);
       }
    return listaNumeros;
    }


}//fin de clase
