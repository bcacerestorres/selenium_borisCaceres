package IntermedioPractico6.testPractico6;

import IntermedioPractico6.utils.DataFactory;
//import ecommerceSite.pageObject.MyAccountPage;
import IntermedioPractico6.pageObjectPractico6.MyAccountPage;
import org.testng.annotations.Test;

public class BuyArticle2Test extends BaseTest {
/*antes de iniciar el refactoring, debo validar que el test funcione.....
    no tengo driver.findBy....
   no tengo Strings "sueltas" en los asserts
    no me comunico directamente con el driver...
    los metodos de las pages, retornan Strings... ó una nueva página...
    existen asserts validando los resultados esperados del test
    utilizo constantes para enviar datos a los tests... no enviar String con palabras "magicas"..
*/

  @Test
  public void buyingDressTest2 () throws InterruptedException {

      //declaracion de variables faker
      String fakeFirstName = DataFactory.getFakeFirstName();
      String fakeLastName = DataFactory.getFakeLastName();
      String randomEmail = DataFactory.randomEmail;

      MyAccountPage myAccountPage = registerAnUser(randomEmail, fakeFirstName, fakeLastName);

       myAccountPage.buscarVestido();



  }


}
