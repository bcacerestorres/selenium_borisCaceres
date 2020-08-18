package Practico10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio10_6 {
    // Crear un método de test llamado birthdateTest
    //Ir a Facebook https://www.facebook.com/
    //Setear la fecha de nacimiento para el 20 de diciembre de 1990
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
    public void birthdateTest(){
        getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;

        driver.findElement(By.cssSelector("#u_0_2")).click();


        WebElement dias= driver.findElement(By.id("day"));
        Select comboDia = new Select (dias);
        comboDia.selectByVisibleText("15");

        WebElement mes= driver.findElement(By.id("month"));
        Select comboMes = new Select (mes);
        comboMes.selectByVisibleText("oct");

        WebElement año= driver.findElement(By.id("year"));
        Select comboAño = new Select (año);
        comboAño.selectByVisibleText("1990");
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
