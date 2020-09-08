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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

//Ejercicio
  //      Entrar al sitio de Docusign: https://docusign.com
     //   Realizar click en “Sign in as a different user”
    //    Realizar click en No account? Sign up for free
public class docusign {
    WebDriver driver;
    private static String DOCUSING_URL = "https://account.docusign.com/#/username";

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(DOCUSING_URL);
    }
    @Test
     public void SignDiferrent(){
     // username
     driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testing@");
     // boton continuar
        driver.findElement(By.xpath("//span[contains(text(),'Continuar')]")).click();
     // no tiene cuenta
        driver.findElement(By.xpath("//a[contains(text(),'¿No tiene cuenta? Regístrese gratis')]")).click();
        // titulo
        System.out.println(driver.getTitle());
       Assert.assertEquals(driver.getTitle(),"DocuSign Free Trial");
    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
     //   driver.quit();
    }


}
