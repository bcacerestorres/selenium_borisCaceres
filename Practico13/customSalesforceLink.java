package Practico13;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.concurrent.TimeUnit;

public class customSalesforceLink {
    WebDriver driver;
    private static String SALESFORCE_URL = "https://login.salesforce.com/";
  //  Ejercicio 12
  //  Crear un método de test llamado customSalesforceLink
  //  Acceder a: https://login.salesforce.com/
 //   Hacer click en el link “User a Custom Domain”
 //   Completar el custom domain con “as”
 //   Hacer click en boton Continue
 //   Mostrar el título de la página
 //   Completar el username y password
 //   Hacer click en Sign in
 //   Volver atras

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);
    }
    @Test
    public void CustomDomain(){
      //  User a Custom Domain
      driver.findElement(By.id("mydomainLink")).click();
      // completacion custom domain
       driver.findElement(By.xpath("//input[@id='mydomain']")).sendKeys("as");
       // boton coninuar
        driver.findElement(By.xpath("//button[@id='mydomainContinue']")).click();
        // mostrar titulo
        System.out.println("el titulo de la pagina de registro dominio \n");
        System.out.println(driver.getTitle());
        // espera de 10 segundos
        WebDriverWait myWaitVar = new WebDriverWait(driver, 10);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        // username
        driver.findElement(By.name("username")).sendKeys("astest");
        // password
        driver.findElement(By.id("okta-signin-password")).sendKeys("astest");
        // sign in
        driver.findElement(By.id("okta-signin-submit")).click();
        // volver a atras
        driver.navigate().back();
       // titulo de volver a tras
        System.out.println("\n");
        System.out.println("el titulo de la pagina al volver a tras \n");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Iniciar sesión | Salesforce");
    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }


}
