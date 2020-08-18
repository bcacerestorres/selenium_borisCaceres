package Practico9;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

public class Ejercicio9_16 {
    //Acceder a Spotify: https://www.spotify.com/uy/
   // Realizar diferentes tests
   // Validar el título de la página
   // Mostrar la cantidad de elementos tipo párrafo
  //  Mostrar la cantidad de links <a> que contiene la página
  //  Imprimir todos el texto de los botones del sitio
   // Hacer click en el link Ayuda
   // Mostrar el texto de la sección principal y escribir Suscripción. Dar “Musica”
   // Mostrar la fecha de la última publicación en pantalla
   // Hacer click en el botón Si dentro de si te resultó útil el artículo
  //  Imprimir todas las opciones del menú izquierdo
   // Volver atras
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
    public void spotifyPagina(){
        getDriver("https://www.spotify.com/uy/");
        driver.manage().window().maximize();

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" el titulo de la pagina es "+driver.getTitle());

        List<WebElement> parrafos  = driver.findElements(By.tagName("p"));
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" la cantidad de elementos tipo p " +parrafos.size());

        List<WebElement> enlace  = driver.findElements(By.tagName("a"));
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" la cantidad de elementos tipo a " +enlace.size());


        List<WebElement> botones = driver.findElements(By.tagName("button"));
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("botones ");
        System.out.println(" la cantidad de elementos botones " +botones.size());
        for(WebElement boton : botones){
            System.out.println(boton.getText());
        }

        driver.findElement(By.linkText("Ayuda")).click();

        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" elementos h1");
        System.out.println(" el numero de elemetos h1  es "+h1s.size());
        for(WebElement h1: h1s){
            System.out.println(h1.getText());
        }

        driver.findElement(By.cssSelector(".Input-sc-1698ofb-0")).sendKeys("Suscripción",Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//a[contains(text(),'Estado de tu suscripción')]")).click();

        System.out.println("---------------------------------------------------------------------------");
        WebElement  fecha =driver.findElement(By.cssSelector("p.Type__TypeElement-sc-9snywk-0:nth-child(4)"));
        System.out.println(fecha.getText());

        System.out.println("---------------------------------------------------------------------------");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement si=driver.findElement(By.xpath("//span[text()='Sí']"));
        //da resultado pero no click WebElement si=driver.findElement(By.xpath("//*[contains(@href,'#')]"));
//WebElement si=driver.findElement(By.cssSelector("#j_id0\\:j_id1\\:j_id13\\:j_id14\\:feedbackYesNoForm\\:feedbackYesButton"));
//WebElement si=driver.findElement(By.id("j_id0:j_id1:j_id13:j_id14:feedbackYesNoForm:feedbackYesButton"));
// WebElement si=driver.findElement(By.name("j_id0:j_id1:j_id13:j_id14:feedbackYesNoForm:feedbackYesButton"));
//WebElement si=driver.findElement(By.linkText("Sí"));
        System.out.println(" el elemento esta visible "+si.isDisplayed());
        System.out.println("el elemento esta disponible "+si.isEnabled());
        si.click();

    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
