package Practico12;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ejercicio_dataProviders {
    //a
   // Crear un método llamado mostrarCapitales
  //  Que muestre en pantalla las capitales que se encuentran en la clase DataProviderClass
    //  con las capitales.
    //b
    //Crear un método llamado mostrarDatosPersonas que reciben el nombre,
    // apellido y edad de las personas.

    @DataProvider(name ="capitales")
    public Object[][] getCapital() {
        Object[][] capital= new Object[][] { { "Santiago" },
                { "Lima" },{ "La Paz" },{ "Buenos Aires" } };
        return capital;
    }

    @DataProvider(name ="DatosPersonales")
    public Object[][] getDatosPersonales() {
        Object[][] DatosPersonas= new Object[3][3];
        DatosPersonas[0][0]="Luis";
        DatosPersonas[0][1]="Pardo";
        DatosPersonas[0][2]=20;
        DatosPersonas[1][0]="Augusto";
        DatosPersonas[1][1]="Perez";
        DatosPersonas[1][2]=30;
        DatosPersonas[2][0]="Leonardo";
        DatosPersonas[2][1]="Reyes";
        DatosPersonas[2][2]=40;
        return DatosPersonas;
    }

    @Test(dataProvider ="capitales")
    public void ImprimirCapitales(String unaCapital) {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("las capitales son \n");
        System.out.println(""+unaCapital);
        System.out.println("-----------------------------------------------------------\n");
    }

    @Test(dataProvider ="DatosPersonales")
    public void mostrarDatosPersonas(String nombre,String apellido, int edad) {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("los nombres , apellido  y edad \n");
        System.out.println(" "+nombre +  "  "+apellido +  " " +edad);
        System.out.println("-----------------------------------------------------------\n");
    }

}
