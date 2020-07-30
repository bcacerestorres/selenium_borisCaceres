import java.util.Scanner;
public class ArrayUtils {

    public static void llenarEntero( int[] numeros){
        Scanner teclado = new Scanner(System.in);
        for(int i=0;i<numeros.length;i++) {
            System.out.print("Ingrese valor:");
            numeros[i]=teclado.nextInt();
        }
    }


    public static void imprimiEnteros(int[] numeros) {
        for(int i=0;i<numeros.length;i++) {
            System.out.println(numeros[i]);
        }
    }

    public void calcularPromedio(int[] numeros) {
        float suma =0;
        float promedio;
        for(int i=0;i<numeros.length;i++) {
            suma=suma+numeros[i];
        }
        promedio=suma/5;
        System.out.println("Promedio de alturas:"+promedio);
    }


}
