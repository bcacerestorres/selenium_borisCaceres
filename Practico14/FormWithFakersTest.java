package Practico14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.util.concurrent.TimeUnit;

public class FormWithFakersTest {
    WebDriver driver;
    private static String SALESFORCE_URL = "https://login.salesforce.com/?locale=eu";

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);
    }
   // Ejercicio :
  //  Crear un método de test llamado fillFormWithFakersTest
  //  Ingresar a la página https://login.salesforce.com/?locale=eu.
 //   Hacer click en botón “Try To Free”
 //   Completar toda la información utilizando el dataFaker. Para ello, debe realizar los
 //   siguientes pasos:
 //   Crear una clase para la DataFaker
 //   Crear una variable estática de tipo Faker dentro de DataFactory
 //   Crear los métodos getFirstName, getLastName, GetEmail, getPhone. Estos métodos
 //   deben retornar un string con un valor random dado por la clase Faker.
 //   El teléfono debe ser un número randómico de 10 dígitos
 //   Mostrar en pantalla los datos enviados al sitio
 //   Validar que la información mostrada al finalizar, sea la correcta
 //   Validar que la información ingresada sea la que se muestra en pantalla

    @Test
    public void fillFormWithFakersTest(){
        // maximizar
        driver.manage().window().maximize();
        // boton try to free
        driver.findElement(By.id("signup_link")).click();
        // espera de 10 segundos
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // variables
        String nombre = DataFactory.getNombre();
        String apellido = DataFactory.getApellido();
        String titulo= DataFactory.getTrabajo();
        String correo = DataFactory.getCorreo();
        String fono = DataFactory.getTelefono();
        String compañia =DataFactory.getEmpresa();

        // escribir nombre
        driver.findElement(By.name("UserFirstName")).sendKeys(nombre);
        // escribir apellido
        driver.findElement(By.name("UserLastName")).sendKeys(apellido);
        // escribir titulo
        driver.findElement(By.name("UserTitle")).sendKeys(titulo);
        // escribir correo
        driver.findElement(By.name("UserEmail")).sendKeys(correo);
        // escribor fono
        driver.findElement(By.name("UserPhone")).sendKeys(fono);
        // escribir compañia
        driver.findElement(By.name("CompanyName")).sendKeys(compañia);
        // selecionar empleo
        Select empleo = new Select(driver.findElement(By.name("CompanyEmployees")));
        empleo.selectByValue("3");
        // selecion lenguaje compañia
        Select lenguaje = new Select(driver.findElement(By.name("CompanyLanguage")));
        lenguaje.selectByValue("en_US");
        // boton star my free trial
        driver.findElement(By.name("Start my free trial")).click();
        //espera
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement MensajeError= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("error-msg-block"))));

        System.out.println(MensajeError.getText());

    }
    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
     //   driver.quit();
    }
}
