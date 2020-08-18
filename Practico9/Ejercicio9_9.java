package Practico9;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio9_9 {
    //Crear un método llamado getDriver que inicialice un sitio web que recibe por parámetro. Debe
   // retornar un objeto de tipo Webdriver
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
    public void ejemplo9(){
        getDriver("https://www.lun.com");
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
