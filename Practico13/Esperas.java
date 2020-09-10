package Practico13;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.concurrent.TimeUnit;

public class Esperas {
    WebDriver driver;
    private static String SALESFORCE_URL = "https://login.salesforce.com/?locale=eu";
    private static String ForgotPassword="Forgot Your Password";
    private static String ForgotAccount="Use Custom Domain";
    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);
    }
    //Thread Sleep
   // Ejercicio
   // Crear un método que acceda a Salesforce y espere 5 segundos antes de hacer click en “Forgot
  //  password”.
    @Test (priority = 0)
    public void ThreadSleep() throws InterruptedException{
        //maximizar
        driver.manage().window().maximize();
        // espera de 5 segundos
        Thread.sleep(5000);
        // forgot password
        driver.findElement(By.id("forgot_password_link")).click();
        // mensaje forgot password
        String mensajeActual= driver.findElement(By.id("header")).getText();
        Assert.assertEquals(mensajeActual,ForgotPassword);
    }

   // Ejercicio
   // Crear un método llamado implicitWaitTest que acceda a Salesforce y espera hasta 10
  //  segundos antes de tirar una excepción.
  //  Hacer click en Forgot Account
   @Test (priority = 1)
   public void implicitWaitTest(){
       //maximizar
       driver.manage().window().maximize();
       // espera de 10 segundos
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // Forgot Account
       driver.findElement(By.id("mydomainLink")).click();
       // mensaje Forgot Account
       String mensajeAccount= driver.findElement(By.id("header")).getText();
       Assert.assertEquals(mensajeAccount,ForgotAccount);
   }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
