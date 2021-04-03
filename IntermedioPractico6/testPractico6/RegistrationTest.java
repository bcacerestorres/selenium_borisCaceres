package IntermedioPractico6.testPractico6;

//import ecommerceSite.pageObject.MyAccountPage;
import IntermedioPractico6.pageObjectPractico6.MyAccountPage;
//import ecommerceSite.pageObject.MyPersonalInformationPage;
import IntermedioPractico6.pageObjectPractico6.MyPersonalInformationPage;
//import ecommerceSite.utils.DataFactory;
import IntermedioPractico6.utils.DataFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

// clase de herencia de base test para el registro

public class RegistrationTest extends BaseTest {
    @Test
    public void registrationTest() throws InterruptedException {
        //antes de iniciar el refactoring, debo validar que el test funcione.....
        //no tengo driver.findBy....
        //no tengo Strings "sueltas" en los asserts
        //no me comunico directamente con el driver...
        //los metodos de las pages, retornan Strings... ó una nueva página...
        //existen asserts validando los resultados esperados del test
        //utilizo constantes para enviar datos a los tests... no enviar String con palabras "magicas"..

        String fakeFirstName = DataFactory.getFakeFirstName();
        String fakeLastName = DataFactory.getFakeLastName();
        String randomEmail = DataFactory.randomEmail;

        MyAccountPage myAccountPage = registerAnUser(randomEmail, fakeFirstName, fakeLastName);

        Thread.sleep(2000);

        MyPersonalInformationPage myPersonalInformationPage = myAccountPage.clickOnMyPersonalInformationBtn();

        String obtainedName = myPersonalInformationPage.getFirstNameValue();
        String obtainedLastName = myPersonalInformationPage.getLastNameValue();
        String obtainedEmail = myPersonalInformationPage.getEmailValue();

        Assert.assertEquals(obtainedName, fakeFirstName );
        Assert.assertEquals(obtainedLastName, fakeLastName );
        Assert.assertEquals(obtainedEmail, randomEmail);
    }

}
