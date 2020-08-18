package Practico9;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio9_7 {
   // Crear un método llamado getWindowsSizeTest
   // Abrir el explorador con google.com
    //Obtener y mostrar el ancho y alto de la página
   // Obtener las dimensiones y mostrarla en pantalla
   // Setear un nuevo tamaño de pantalla 1024x768
   // Validar que el ancho y el alto sea el esperado
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
    public void getWindowsSizeTest(){
        getDriver("https://www.google.com");
        int alto= driver.manage().window().getSize().getHeight();
        int ancho = driver.manage().window().getSize().getWidth();

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(alto);
        System.out.println(ancho);

        Dimension size = driver.manage().window().getSize();
        int alto1= size.getHeight();
        int ancho1= size.getWidth();

        driver.manage().window().setSize(new Dimension(1024,768));

        alto=driver.manage().window().getSize().getHeight();
        Assert.assertEquals(ancho,1024);

        ancho=driver.manage().window().getSize().getWidth();
        Assert.assertEquals(alto,768);
        System.out.println("---------------------------------------------------------------------------");
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
