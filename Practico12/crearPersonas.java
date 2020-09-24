package Practico12;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class crearPersonas {
   // Ejercicio
  //  Crear una clase llamada testngSalesforce que importe import org.testng.annotations.DataProvider;
  //  Crear un método llamado crearPersonas  que retorne una matriz de tipo object
    //  con dos nombres y dos edades.

    @DataProvider(name ="personas")
    public Object[][] getData() {
        Object[][] data= new Object[2][2] ;
        data[0][0]="Juan";
        data[0][1]=20;
        data[1][0]="Pedro";
        data[1][1]=30;
        return data ;
    }

    @Test(dataProvider ="personas")
    public void ImprimirPersonas(String nombre, int edad) {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("los nombres y edad \n");
        System.out.println(" "+nombre +  "  "+edad);
        System.out.println("-----------------------------------------------------------\n");
    }

}
