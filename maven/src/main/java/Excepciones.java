public class Excepciones {
    public static void main (String args[]) {
        //Pedir el ingreso de un número, e ingresar una letra
        System.out.println("Bienvenido al Programa!!");
        try {
            int num = JavaUtils.ingresarNumero("Ingrese un numero");
              } catch (Exception a) {
            System.out.println("Deberia haber ingresado un numero!!!");
            System.out.println(a);
              }
       // Definir un arreglo de 3 posiciones y mostrar la posicion 3
        System.out.println("---------------------------------------------");
        int [] arreglo = new int[3];
        try {
            System.out.println(arreglo[3]);
            } catch (Exception b){
            System.out.println("Esa posicion no existe en el arreglo!!");
            System.out.println(b);
            }
       // Definir una variable double llamada promedio y realizar la siguiente operación: 3/0
        System.out.println("---------------------------------------------");
        try {
            float promedio = 3 / 0;
            System.out.println("El promedio es " + promedio);
            } catch (Exception c) {
            System.out.println("El promedio es 0!!!");
            System.out.println(c);
            }

        System.out.println("---------------------------------------------");
        boolean esNumero = JavaUtils.validarEnteros("126");
        System.out.println(esNumero);
           if(esNumero == true){
               System.out.println("se valido y es numero");
           }else {
               System.out.println("se valido y no es numero");
           }

        System.out.println("---------------------------------------------");
           boolean esEntero = JavaUtils.validarEnterosMensaje("dfsf","es un entero","es un cadena");
        System.out.println(esEntero);

        System.out.println("---------------------------------------------");
        Camiones camion1= new Camiones(2233,"Amarillo","Ford 15000");
        System.out.println(camion1);
    }
}
