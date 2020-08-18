package Practico9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Ejercicio9_17 {
  //  Crear un método de test llamado sendKeysToFacebook
  //  Ir a Facebook https://www.facebook.com/
  // Completar el email y contraseña con los datos: test@test.com y holamundo
  //          respectivamente
  //  Hacer click en login
  //  Validar que se despliegue un mensaje de error
  WebDriver driver;

    private WebDriver getDriver(String url){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        String baseUrl = url;
        driver.get(baseUrl);

        return driver;
    }

    @Test
    public void sendKeysToFacebook(){
        getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("pass")).sendKeys("holamundo");
        driver.findElement(By.id("u_0_b")).click();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        String TituloActual = driver.findElement(By.xpath("//h1[contains(text(),'Sorry, something went wrong.')]")).getText();
        String TituloEsperado="Sorry, something went wrong.";
        Assert.assertEquals(TituloActual,TituloEsperado);
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
