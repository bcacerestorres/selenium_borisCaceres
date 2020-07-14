import java.util.Random;
import java.util.Scanner;
public class metodos_arreglos {
    // main
    public static void main(String[] args) {
        //Definir un arreglo de Double de 16 posiciones. Imprimir todos los valores del mismo.
        double [ ] a = new double [16];
        llenarDouble(a);
         imprimirDouble(a);
       // Definir un arreglo de Booleanos con 9 posiciones. Imprimir todos los valores del arreglo.
        boolean[] b = new boolean[9];
        b[0]=true;
        b[1]=false;
        b[2]=true;
        b[3]=false;
        imprimirBoolean(b);
      //  Crear un array de números de 100 posiciones, que contendrá los números del 1 al 100.
        //  Obtener la suma de todos ellos y el promedio.
          int []  c= new int [100];
        int pivoteInt=1;
        int suma = 0;
        // llenar arreglo
        for(int j=0;j<c.length;j++){
            c[j]=pivoteInt;
            pivoteInt++;
            suma = suma + pivoteInt;
        }
        float promedio = suma / c.length;
        imprimirInt(c);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("El promedio es " + promedio);
       // Llenar un array con números aleatorios. Imprimir todos los números en pantalla.
        int []  d= new int [20];
        System.out.println("-------------------------------------------------------------------------");
         llenarAletorio(d);
         imprimirInt(d);

        //Crear un array de booleanos con 10 posiciones llamado asientosLibres y
        // colocar todos sus elementos en true.
        boolean [ ] asientosLibres= new boolean[10];
        System.out.println("-------------------------------------------------------------------------");
         llenarTrue(asientosLibres);
         imprimirBoolean(asientosLibres);
        System.out.println("valores del tipo : "+hayVacantes(asientosLibres));
        System.out.println("todos los valores son: "+todosVerdaderos(asientosLibres));
        System.out.println("-------------------------------------------------------------------------");

       // Contar el número de elementos positivos, negativos y ceros en un array de 5 enteros.
        //Mostrar la cantidad de números positivos, negativos y ceros: Ej. “Se ingresaron 2 números positivos, 1 número negativo y 1 cero”
        int []  e= new int [5];
        int positivo=0;
        int negativo =0;
        int cero=0;
        e[0]=-2;
        e[1]=-1;
        e[2]=-2;
        e[3]=1;
        e[4]=2;

        for(int j=0;j<e.length;j++){
         if(e[j]> 0){  // positivo
          positivo++;
           }else if(e[j] < 0){  // negativo
             negativo++;
            }else {  // cero
             cero++;
            }
        }
        // imprimir
        imprimirInt(e);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Positivos: " + positivo);
        System.out.println("Negativos: " + negativo);
        System.out.println("Ceros: " + cero);
        System.out.println("cantidad de elementos: " +cantidadElementos(e));
        System.out.println("El mayor numero  es : "+mayorElemento(e));
        System.out.println("El menor numero : "+menorElemento(e)) ;
        System.out.println("-------------------------------------------------------------------------");
         //
        crearArregloBooleano();
        //
        float []  g= new float [10];
        llenarfloat(g);
        System.out.println("-------------------------------------------------------------------------");
        imprimirFload(g);
        System.out.println("la suma es : " +calcularSuma(g));
        System.out.println("El promedio es : " +calcularPromedio(g));

        //
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("el valor ingresado esta en el arreglo entero :  "+estanum(e));
        System.out.println("-------------------------------------------------------------------------");
    } // fin mnain


    //metodo para imprimir double
    public static void imprimirDouble (double [] arregloDuble) {
        System.out.println("------------------ Imprimiendo Arreglo de tipo double -----------------------");
        for (int i = 0; i < arregloDuble.length; i++) {
            System.out.println("Posicion " + i + " es: " + arregloDuble[i]);
        }
    }
    //metodo para imprimir boolean
    public static void imprimirBoolean (boolean [] arregloBoolean) {
        System.out.println("------------------ Imprimiendo Arreglo de tipo boolean -----------------------");
        for (int i = 0; i < arregloBoolean.length; i++) {
            System.out.println("Posicion " + i + " es: " + arregloBoolean[i]);
        }
    }
    //metodo para imprimir int
    public static void imprimirInt (int [] arregloInt) {
        System.out.println("------------------ Imprimiendo Arreglo de tipo int -----------------------");
        for (int i = 0; i < arregloInt.length; i++) {
            System.out.println("Posicion " + i + " es: " + arregloInt[i]);
        }
    }

    //metodo para imprimir float
    public static void imprimirfload (float [] arreglofload) {
        System.out.println("------------------ Imprimiendo Arreglo de tipo fload -----------------------");
        for (int i = 0; i < arreglofload.length; i++) {
            System.out.println("Posicion " + i + " es: " + arreglofload[i]);
        }
    }

    // Crear un método que muestre en pantalla todos los elementos de un array de float
    public static void imprimirFload (float [] arreglofload) {
        System.out.println("------------------ Imprimiendo Arreglo de tipo int -----------------------");
        for (int i = 0; i < arreglofload.length; i++) {
            System.out.println("Posicion " + i + " es: " + arreglofload[i]);
        }
    }

    // metodo de llenar  aleatorio
    public static int[] llenarAletorio(int [] arregloInt){
        System.out.println("LLenando areglo de entero con valores aleatorio....");
        for(int i=0;i<arregloInt.length;i++){
            arregloInt[i] = new Random().nextInt(60);
        }
        return arregloInt;
    }
// metodo de llenar double
public static double [] llenarDouble( double [] arregloDuble){
    System.out.println("LLenando arreglo de tipo double....");
    for(int i=0;i<arregloDuble.length;i++){
        arregloDuble[i] = new Random().nextInt(60);
    }
    return arregloDuble;
}
// metodo de llenar true
    public static boolean [] llenarTrue( boolean [] arregloboolean){
        System.out.println("LLenando arreglo de tipo boolean....");
        for(int i=0;i<arregloboolean.length;i++){
            arregloboolean[i] =true;
        }
        return arregloboolean;
    }

    // metodo llenar float
    public static float [] llenarfloat( float [] arreglofloat){
        System.out.println("LLenando arreglo de tipo float....");
        for(int i=0;i<arreglofloat.length;i++){
            arreglofloat[i] = new Random().nextInt(60);
        }
        return arreglofloat;
    }

   // Crear un método que reciba un arreglo, y retorne la cantidad de elementos de la misma.
 public static int cantidadElementos(int [] arregloInt ){
        return arregloInt.length;
 }

 //Crear un método llamado crearArregloBooleano que retorne un arreglo de 10
public static boolean []crearArregloBooleano(){
    boolean[] f = new boolean[10];
    System.out.println("------------------ creando un arreglo boolean -----------------------");
    for(int i=0;i<10;i++){
        f[i] =false;
    }
        return f;
  }


   // Crear un método que reciba una arreglo, y retorne el promedio de los mismos.
public static float calcularPromedio(float [] arreglofloat){
float suma =0;
    for(int j=0;j<arreglofloat.length;j++){
        suma = suma + arreglofloat[j];
    }
    return suma / arreglofloat.length;
 }
    //Crear un método que reciba un arreglo, y retorne la suma.
    public static float calcularSuma(float [] arreglofloat){
        float suma =0;
        for(int j=0;j<arreglofloat.length;j++){
            suma = suma + arreglofloat[j];
        }
        return suma;
    }

    //Crear un método que reciba un arreglo de enteros, y retorne el menor.
    public static  int menorElemento(int [] arregloInt){
      int menor =arregloInt[0];
      for (int j=0;j <arregloInt.length;j++){
          if(arregloInt[j]<menor) {
              menor = arregloInt[j];
          }
      }
  return menor;
    }

   // Crear un método que reciba un arreglo de enteros, y retorne el mayor.
   public static int mayorElemento(int [] arregloInt){
       int mayor =arregloInt[0];
       for (int j=0;j <arregloInt.length;j++){
           if(arregloInt[j] >mayor) {
               mayor = arregloInt[j];
           }
       }
       return mayor;
   }

  //  Crear un método llamado hayVacantes que reciba un arreglo de booleanos
    //  y retorne verdadero si alguna de sus posiciones esta en true, de lo contrario,
    //  deberá retornar false.
public static boolean hayVacantes(boolean [] arregloboolean){
      for(int j=0;j<arregloboolean.length;j++){
          if(arregloboolean[j] == true){
             return true;
          }
      }
      return false;
  }

   // Crear un método que reciba un arreglo de booleanos y
    // retorne true si y sólo si, todos los elementos son verdaderos.
   public static boolean todosVerdaderos(boolean [] arregloboolean){
        int contador=0;
       for(int j=0;j<arregloboolean.length;j++){
           if(arregloboolean[j] == true){
               contador++;
           }
       } // fin for

       if(contador ==arregloboolean.length ){
         return true;
       }
       return false;
   }


    //Crear un método reciba un arreglo de enteros por parámetro y
    // que solicite el ingreso de un valor.
    // Debe retornar true si y sólo si el valor ingresado por el usuario se encuentra en el arreglo.
public static boolean estanum(int [] arregloInt){
    Scanner input = new Scanner(System.in);
    System.out.println("Ingrese un numero: ");
    int num = input.nextInt();
        for (int j = 0; j < arregloInt.length; j++) {
        if(num == arregloInt[j]) {
            return true;
        }
    }
   return false;
}

} // fin clase
