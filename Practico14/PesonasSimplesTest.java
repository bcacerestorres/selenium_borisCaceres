package Practico14;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PesonasSimplesTest {

    @DataProvider(name = "personas")
    public Object[][]CrearPersonas(){
    return new Object[][]{{"Esteban",20},{"Enrique",30}};
    }

    @Test(dataProvider = "personas")
  public void nombreTests(String Unombre, int Unaedad){
    System.out.println("El nombre es :  "+ Unombre + "  edad  :  " +Unaedad);
    }

    @Test(dataProviderClass = DataProviderPeople.class , dataProvider="people")
    public void PeopleTest(String nombre, String apellido , int edad){
    System.out.println("Nombre : "+ nombre + " apellido : "+apellido+ " edad : "+edad);
    }
}
