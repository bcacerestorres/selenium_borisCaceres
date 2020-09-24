package Practico12;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.GetProperties;
import java.security.Key;
import java.util.List;

public class spotifyTestWithParameters {
    WebDriver driver;
    private static String SPOTIFY_URL = "https://www.spotify.com/uy/";
    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
    }
   // Ejercicio
  //  Agregar en el testng.xml, un parámetro de tipo String llamado specificTag y que su valor sea h2
  // Crear una clase llamada spotifyTestWithParameters
  //  Agregar el @setup y un metodo llamado spotifyTags.
    //  Este meétodo deberaá imprimir todas los estilos H del sitio,
    //  dependiendo del parámetro recibido. Si no hay ningun parámetro, se deberá mostrar los h1
   @Test
   @Parameters ({"specificTag"})
   public void spotifyTags(@Optional("h1") String tag){
       List<WebElement> elements = driver.findElements(By.tagName(tag));
       System.out.print("---------------------------------------------------------------------------------------");
       System.out.print("\n");
       System.out.print("Se mostran los elementos: ");
       if (tag.equals("h2")){
           System.out.println("H2");
       } else if (tag.equals("h3"))
       {
           System.out.println("H3");
       } else if (tag.equals("h4"))
       {
           System.out.println("H4");
       } else
           {
           System.out.println(tag);
           }
       System.out.print("\n");
       System.out.print("---------------------------------------------------------------------------------------");
       System.out.print("\n");
       for (WebElement e : elements) {
           System.out.println(e.getText());
       }
       System.out.print("\n");
       System.out.print("---------------------------------------------------------------------------------------");
    }

    @AfterMethod
    public void closedriver(){
   //     driver.quit();
        //     driver.close();
    }
}
