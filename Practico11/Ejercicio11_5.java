package Practico11;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import utilities.GetProperties;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
public class Ejercicio11_5 {
    // Acceder a www.gmail.com
    //  Mover el slider hacia la derecha
    //  Luego volver a la izquierda
    //  Hacer click en “Crear Cuenta”
    //  Completar los datos del formulario
    // Una vez completados todos los datos, hacer click en el botón ver contraseña
    //  Hacer click en siguiente

    private WebDriver getDriver(String url) {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        return driver;
    }


    @Test
    public void CrearCuenta() {
        WebDriver driver = getDriver("https://www.gmail.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//span[@class='NlWrkb snByac']")).click();

        WebElement parami=  driver.findElement(By.xpath("//div[contains(text(),'Para mí')]"));
        parami.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",parami);

        //System.out.print("es visible "+parami.isDisplayed());
      //  System.out.print("esta selecionado "+parami.isSelected());
       // System.out.print("esta habilitado "+parami.isEnabled());

        // clicl en para mi
        //driver.findElement(By.xpath("//div[@class='jO7h3c']")).click();

      driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("armando");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("luna");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("aluna");
        driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("contraseña");
        driver.findElement(By.xpath("//input[@name='ConfirmPasswd']")).sendKeys("contraseña");

        driver.findElement(By.xpath("//span[@class='JIzqne IMVfif']//*[local-name()='svg']")).click();

        driver.findElement(By.xpath("//div[@id='accountDetailsNext']")).click();


    }

}
