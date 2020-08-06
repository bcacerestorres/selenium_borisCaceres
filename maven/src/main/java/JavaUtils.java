import java.util.Scanner;
public class JavaUtils {
   public static final Scanner input = new Scanner(System.in);

    public static int ingresarNumero(String mensaje){
       // Scanner input = new Scanner(System.in);
        System.out.println(mensaje);
        int num = input.nextInt();
        return num;
    }

    //Crear un método que permita validar la recepción de enteros
public static boolean validarEnteros(String cadena){
         try{
             Integer.parseInt(cadena);
             return true;
         } catch(NumberFormatException nfe){
             return false;
                 }
       }

// Crear un método que permita validar la recepción de enteros, y
// reciba un mensaje de error y un mensaje de éxito
public static boolean validarEnterosMensaje(String cadena,String mensajeExito, String mensajeError){
        try{
        Integer.parseInt(cadena);
        System.out.println(mensajeExito);
        return true;
        }
        catch(NumberFormatException nfe){
            System.out.println(mensajeError);
        return false;
        }
       }

    public static void bienvenida(){
        System.out.println("Bienvenido al Programa!!");
    }

    public static void finalizarPrograma(){
        System.out.println("El programa ha finalizado!!");
    }

    public static String ingresarPalabra (String mensaje){
       // Scanner input = new Scanner(System.in);
        System.out.println(mensaje);
        String palabra = input.next();
        return palabra;
    }

  public static float ingresarFloantes(String mensaje){
     // Scanner input = new Scanner(System.in);
      System.out.println(mensaje);
      float flotante=input.nextFloat();
      return flotante;
   }


}
