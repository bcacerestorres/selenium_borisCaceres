package Practico9;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio9_10 {
    //Crear un método llamado searchInGoogle
   // Acceder a google.com
   // Ingresar en el buscador, la palabra “WebElement” y presionar enter
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
    public void searchInGoogleTest(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.google.com";
        driver.get(baseUrl);

        driver.findElement(By.name("q")).sendKeys("WebElement"+ Keys.ENTER);

    }

    @AfterTest
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

}
