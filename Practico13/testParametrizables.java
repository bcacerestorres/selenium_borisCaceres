package Practico13;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.GetProperties;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testParametrizables {
  //  Ejercicio 1
  //  Crear un archivo testRunner.xml dentro de una carpeta runners. Agregar las clases de test que
 //   se encuentran dentro del proyecto.

  //  Ejercicio 2
 //   Realizar una clase llamada testParametrizables y un método llamado pruebaConParametros
 //   que reciba por parámetro un tipo de tagName. En base a si el parámetro es ​h1, h2 y h3
 //   mostrar en pantalla lo que se va a imprimir, y obtener por su tagname todos los elementos.
 //   Luego imprimirlos en pantalla. En caso de que no se encuentren elementos, se debe mostrar
 //   un mensaje indicando que no se encontraron seleccionados.

//    Ejercicio 3
//    Realizar un xml que permite correr un cierto grupo de tests. Crear un testGroup.xml para este
 //   ejercicio.
    WebDriver driver;
    private static String SPOTIFY_URL = "https://www.spotify.com/uy/signup/";
    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
    }

    @Test
    @Parameters({"tagName"})
    public void pruebaConParametros(@Optional("a") String tag){
   // lista de elementos
        List<WebElement> elementos = driver.findElements(By.tagName(tag));
        System.out.print("-------------------------------------------------------------------------\n");
        System.out.print("Se mostraran los elementos\n");

        if(tag.equals("h1"))
        {
           System.out.println(" H1");
        }
        else if(tag.equals("h2"))
        {
            System.out.println(" H2\n");
        }
        else if(tag.equals("h3"))
        {
            System.out.println(" H3\n");
        }
        else if(tag.equals("a"))
        {
            System.out.println("hipervinculo\n");
        }
        else
            {
                System.out.println("no se encontro elemento\n");
            }
        // impresion elementos
        for(WebElement e: elementos){
            System.out.println(e.getText());
        }
        System.out.print("-------------------------------------------------------------------------\n");

    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

}
