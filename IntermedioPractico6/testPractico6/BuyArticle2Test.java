package IntermedioPractico6.testPractico6;

import IntermedioPractico6.utils.DataFactory;
//import ecommerceSite.pageObject.MyAccountPage;
import IntermedioPractico6.pageObjectPractico6.MyAccountPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

      myAccountPage.selecionarVestido();

      myAccountPage.cartButton();

      myAccountPage.modaltoOpen();

      myAccountPage.checkoutPage();

      myAccountPage.addressBox();

      myAccountPage.orderCarrier();

      myAccountPage.paymentSection();

      myAccountPage.bankwireOption();

      String mensajeFinal = myAccountPage.confirmingOrder();

      //assertions

  Assert.assertTrue(mensajeFinal.contains("Your order on My Store is complete."),"no contiene la palabra  ....Your order on My Store is complete ");
  Assert.assertTrue(mensajeFinal.contains("$30.98")," no contiene ........30.98");
  Assert.assertTrue(mensajeFinal.contains("Name of account owner Pradeep Macharla")," no contiene ..... Name of account owner Pradeep Macharla");
  Assert.assertTrue(mensajeFinal.contains("Include these details xyz"),"no contiene -... Include these details xyz");
  Assert.assertTrue(mensajeFinal.contains("Bank name RTP"), " no contien ...Bank name RTP");
  //Assert.assertTrue(mensajeFinal.contains("Your order will be sent as soonas we receive payment"),"no contiene --Your order will be sent as soonas we receive payment");
  Assert.assertTrue(mensajeFinal.contains("Your order will be sent as soon as we receive payment."),"no contiene --Your order will be sent as soonas we receive payment");
      }


}
