package Practico13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSpotify {
   // Ejercicio
 //   Crear una clase llamada SpotifyTest.
 //   Dividir el test en test dependientes uno de otros, de forma tal que el último test, valide los
 //   mensajes de error desplegado en pantalla al clickear el botón de registrarse. Se debe
 //   completar solo los dos primeros campos del formulario de registro y usar la notación:
 //   dependentOnMethods. Agregar asserts y waits
   WebDriver driver;
    private static String SPOTIFY_URL = "https://www.spotify.com/";

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
    }
   @Test
   public void ValidarTitulo(){
    driver.get(SPOTIFY_URL);
       System.out.print("-------------------------------------------------------------------------\n");
       System.out.println("validacion del titulo\n");
    System.out.println(driver.getTitle());
    // validar el titulo de la pagina
       Assert.assertEquals(driver.getTitle(),"Escuchar es todo - Spotify");
       System.out.print("\n");
       System.out.print("-------------------------------------------------------------------------\n");

   }
    @Test(dependsOnMethods = {"ValidarTitulo"})
    public void ValidarRegistrate(){
        // registrarme
        driver.findElement(By.linkText("Regístrate")).click();
        System.out.print("-------------------------------------------------------------------------\n");
        System.out.println("validacion del registrarme\n");
        System.out.println(driver.getTitle());
        // validarl titulo de la pagina de registro
        Assert.assertEquals(driver.getTitle(),"Registrarte - Spotify");
        System.out.print("\n");
        System.out.print("-------------------------------------------------------------------------\n");
        // email
        driver.findElement(By.id("email")).sendKeys("testing2020@gmail.com");
        // confirmacion
        driver.findElement(By.id("confirm")).sendKeys("testing2020@gmail.com");
        //contraseña
        driver.findElement(By.id("password")).sendKeys("79862dfgfdfg");
    }

    @Test(dependsOnMethods ={"ValidarTitulo","ValidarRegistrate"})
    public void BotonRegistrarte(){
        // registrarme
        driver.findElement(By.linkText("Regístrate")).click();
     // boton registrarme
     driver.findElement(By.xpath("//button[@class='Button-oyfj48-0 eEPJyH SignupButton___StyledButtonPrimary-cjcq5h-1 deUbNh']")).click();
    }
    @Test(dependsOnMethods ={"ValidarTitulo","ValidarRegistrate","BotonRegistrarte"})
    public void ValidarFaltaPerfil (){
        // registrarme
        driver.findElement(By.linkText("Regístrate")).click();
        // boton registrarme
        driver.findElement(By.xpath("//button[@class='Button-oyfj48-0 eEPJyH SignupButton___StyledButtonPrimary-cjcq5h-1 deUbNh']")).click();
        // espera de 10 segundos
        WebDriverWait wait =new WebDriverWait(driver,15) ;
        // mensaje perfil
        WebElement FaltaPerfil =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Introduce un nombre para tu perfil.')]"))));
        //validacion perfil
        System.out.println(FaltaPerfil.getText());
        Assert.assertEquals(FaltaPerfil.getText(),"Introduce un nombre para tu perfil.");

        // mensaje dia
        WebElement FaltaDia =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Indica un día del mes válido.')]"))));
        //validacion dia
        System.out.println(FaltaDia.getText());
        Assert.assertEquals(FaltaDia.getText(),"Indica un día del mes válido.");
        // mensaje mes
        WebElement FaltaMes =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu mes de nacimiento.')]"))));
        //validacion mes
        System.out.println(FaltaMes.getText());
        Assert.assertEquals(FaltaMes.getText(),"Selecciona tu mes de nacimiento.");
        // mensaje año
        WebElement FaltaAño =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Indica un año válido.')]"))));
        //validacion año
        System.out.println(FaltaAño.getText());
        Assert.assertEquals(FaltaAño.getText(),"Indica un año válido.");

     // mensaje genero
        WebElement FaltaGenero =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu sexo.')]"))));
        //validacion genero
        System.out.println(FaltaGenero.getText());
        Assert.assertEquals(FaltaGenero.getText(),"Selecciona tu sexo.");

        // mensaje robot
        WebElement FaltaRobot =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Confirma que no eres un robot.')]"))));
        //validacion robot
        System.out.println(FaltaRobot.getText());
        Assert.assertEquals(FaltaRobot.getText(),"Confirma que no eres un robot.");
    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

}
