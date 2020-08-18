package Practico9;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
public class Ejercicio9_6 {
   // Crear un método llamado getTileTest
   // Debe inicializar Google.com
   // Validar que el título del sitio sea Google. Si lo es, debe indicar “Test Passed!!” sino, debe
   // mostrar “Test failed”.

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
    public void getTileTest(){
        getDriver("https://www.google.com");
        String tituloEsperado="Google";
        String tituloActual="";

        // extraer titulo actual
        tituloActual=driver.getTitle();
        System.out.println("---------------------------------------------------------------------------");
        if(tituloActual.contentEquals(tituloEsperado)){
            System.out.println("Test Passed!!");
        }
        else{
            System.out.println("Test failed");
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
