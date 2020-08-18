package Practico9;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GetProperties;
public class Ejercicio9_1 {
  //  Crear un método que abra el browser y muestre el explorador de google con chrome
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
    public void ejercicio_1(){
        getDriver("http://www.google.com");
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
