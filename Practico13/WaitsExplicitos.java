package Practico13;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.ElementNotVisibleException;

public class WaitsExplicitos {
    WebDriver driver;
    private static String SPOTIFY_URL = "https://www.spotify.com/uy/signup/";
    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
    }
  //  Ejercicio
  //  Acceder a https://www.spotify.com/uy/signup/
  //  Completar el email y la confirmación del email con test@test.com
  //  Esperar que aparezca el mensaje de error utilizando un explicit wait
 //   Validar que el mensaje de error sea "Este correo electrónico ya está conectado a una
 //   cuenta.”
    @Test (priority = 0)
    public void EsperasExplicitas(){
        //maximizar
        driver.manage().window().maximize();
        // email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@test.com");
        // confirmacion
        driver.findElement(By.xpath("//input[@id='confirm']")).sendKeys("test@test.com");
        // password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Keys.ENTER);
        // espera de 10 segundos
        WebDriverWait myWaitVar = new WebDriverWait(driver, 20);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]")));
        // mensaje
        WebElement emailExiste = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));
        String mensajeError= emailExiste.getText();
        // validacion
        Assert.assertTrue(mensajeError.contains("Este correo electrónico ya está conectado a una cuenta."));
    }
   @Test (priority = 1)
    public void EsperaFluida(){
        //maximizar
        driver.manage().window().maximize();
        // email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@test.com");
        // confirmacion
        driver.findElement(By.xpath("//input[@id='confirm']")).sendKeys("test@test.com");
       // perfil
        driver.findElement(By.id("displayname")).sendKeys(Keys.ENTER);
       // espera fluida
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement nombrePerfil= wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver ) {
                return driver.findElement(By.xpath("//*[contains(text(),'Introduce un nombre para tu perfil.')]"));
            }
        });
        // mensaje
        WebElement perfil = driver.findElement(By.xpath("//*[contains(text(),'Introduce un nombre para tu perfil.')]"));
        String mensajeperfil= perfil.getText();
        Assert.assertTrue(mensajeperfil.contains("Introduce un nombre para tu perfil."));
    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
       driver.quit();
    }

}
