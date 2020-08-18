package Practico10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio10_2 {
    // Crear un método de test llamado forgotAccountPartialLink
    // Ir a Facebook https://www.facebook.com/
    //Hacer click en Forgot utilizando el partialLink

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
    public void forgotAccountPartialLink(){
        getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@.com");
        driver.findElement(By.partialLinkText("¿Has olvidado los datos de la")).click();
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
