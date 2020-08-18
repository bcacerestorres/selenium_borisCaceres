package Practico10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Ejercicio10_7 {
    //   Crear un método de test llamado comboboxTest
    //  Ir a Facebook https://www.facebook.com/
    //  Obtener el elemento birthday por su nombre
    //  Seleccionar el elemento de enero, febrero y por último marzo
    //  Validar que la lista no este vacia
    //Validar que haya un único valor seleccionado. (eventualmente podria haber mas)

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

        WebElement mes= driver.findElement(By.id("month"));
        Select comboMes = new Select (mes);

        List<WebElement> opciones= comboMes.getOptions();
        Assert.assertNotEquals(0,opciones.size());

        boolean encontrar = false;

        for(WebElement opt:opciones){
            System.out.println(opt.getText());
            if(opt.getText().contentEquals("abr")){
                encontrar=true;
                break;
            }
        }
        Assert.assertTrue(encontrar);
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
