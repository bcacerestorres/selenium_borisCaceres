package Practico15.ejercicio1.Tests;

import Practico15.ejercicio1.PageOjects.SalesforceLandingPage;
import Practico14.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;

public class SalesforceTest {
 //   private static String SALESFORCE_URL ="https://login.salesforce.com/?locale=eu";
    private WebDriver driver;
    private SalesforceLandingPage salesforceLandingPage;

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(Constans.SALESFORCE_URL);
        salesforceLandingPage = new SalesforceLandingPage(driver);
    }

    @Test (priority = 0)
    public void salesforceFirstTest(){
        String errMsg = salesforceLandingPage.loginToSalesforceWithWrongCredentials();
        System.out.println(errMsg);
        Assert.assertEquals(errMsg, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
    }

    @Test (priority = 1)
    public void salesforceSecondTest  (){
       String titulo = salesforceLandingPage.UseCustomDomain();
       System.out.println(titulo);
       Assert.assertEquals(titulo,"Iniciar sesión");
    }

    @Test (priority = 2)
    public void salesforceTreeTest (){
      String mensaje= salesforceLandingPage.ForgotYourPassword();
      System.out.println(mensaje);
      Assert.assertEquals(mensaje,"Not a customer?");
    }

    @Test (priority = 3)
    public void salesforceFourTest(){
        salesforceLandingPage.tryforfree();
        Boolean ErrorCorreo= false;
        // lista de mensaje de error
        List<WebElement> MensajeError = driver.findElements(By.className("error-msg"));
        // recorrer la lista
        for(WebElement we:MensajeError){
            if(we.getText().equals("Enter a valid email address")){
                ErrorCorreo= true;
            }
        }
        // VALIDACION
        Assert.assertFalse(ErrorCorreo);
        System.out.println(ErrorCorreo);
    }

    @Test (priority = 4)
    public void salesforceFiveTest (){
        Boolean check=salesforceLandingPage.RememberMeIsSelected();

        if (check)
        {
            System.out.println("Checkbox esta selecionada");
        }
        else {
            System.out.println("Checkbox no esta selecionadado");
        }

        Assert.assertTrue(check);
    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

}
