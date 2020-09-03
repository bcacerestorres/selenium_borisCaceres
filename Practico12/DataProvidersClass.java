package Practico12;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersClass {
  //  Ejercicio
  //  Crear una clase llamada DataProvidersClass que importe import org.testng.annotations.DataProvider;
  //  Y tenga los métodos de la matriz
  //  Crear una clase que reciba a través de un data provider, los diferentes tipos de
    //  browser que se deben cargar
  @DataProvider(name ="navegadores")
  public Object[][] getNavegador() {
      Object[][] navegador= new Object[][] { { "Internet Explorer" }, { "Mozilla Firefoz" },
              { "Google Chrome" },{ "Brave" } };
      return navegador;
  }
    @Test(dataProvider ="navegadores")
    public void ImprimirNavegadores(String unNavegador) {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("los navegadores son \n");
        System.out.println(""+unNavegador);
        System.out.println("-----------------------------------------------------------\n");
    }

}
