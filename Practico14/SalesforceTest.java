package Practico14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

public class SalesforceTest {
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
   // Crear un método de test llamado testingErrorMessages
  //  Ingresar a la página https://login.salesforce.com/?locale=eu.
  //  Hacer click en botón Try To Free
  //  Dar click en el botón de “Start my free trial”
  //  Mostrar todos los mensajes de error en pantalla
  //  Agregar un assert con todos los elementos que se espera que tengan un error,
   // utilizando assertTrue.
   @Test (priority = 0)
   public void testingErrorMessages(){
        // maximizar
       driver.manage().window().maximize();
        // boton try to free
       driver.findElement(By.id("signup_link")).click();
       // espera de 10 segundos
       WebDriverWait myWaitVar = new WebDriverWait(driver, 10);
       myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.name("Start my free trial")));
       // boton star my free trial
       driver.findElement(By.name("Start my free trial")).click();
       // lista de mensaje de error
       List<WebElement> MensajeError = driver.findElements(By.className("error-msg"));
       //  variable pivote
       Boolean ErrorNombre= false;
       Boolean ErrorApellido= false;
       Boolean ErrorTitulo= false;
       Boolean ErrorCorreo= false;
       Boolean ErrorFono= false;
       Boolean ErrorCompañia= false;
       Boolean ErrorEmpleado= false;
       Boolean ErrorLenguaje= false;

       for(WebElement we : MensajeError){
       System.out.println(we.getText());
          if(we.getText().equals("Enter your first name")){
              ErrorNombre = true;
          }
          else if(we.getText().equals("Enter your last name")){
              ErrorApellido= true;
          }
          else if(we.getText().equals("Enter your title")){
              ErrorTitulo= true;
          }
          else if(we.getText().equals("Enter a valid email address")){
              ErrorCorreo= true;
          }
          else if(we.getText().equals("Enter a valid phone number")){
              ErrorFono = true;
          }
          else if(we.getText().equals("Enter your company name")){
              ErrorCompañia= true;
          }
          else if(we.getText().equals("Select the number of employees")){
              ErrorEmpleado= true;
          }
          else if(we.getText().equals("Select company language")){
              ErrorLenguaje=true;
          }

       }
       // mensaje de no presionar
       WebElement NoAgregado= driver.findElement(By.xpath("//*[contains(text(),'Please read and agree to the Master Subscription Agreement')]"));
       System.out.println(NoAgregado.getText());

       // assert
       Assert.assertTrue(ErrorNombre);
       Assert.assertTrue(ErrorApellido);
       Assert.assertTrue(ErrorTitulo);
       Assert.assertTrue(ErrorCorreo);
       Assert.assertTrue(ErrorFono);
       Assert.assertTrue(ErrorCompañia);
       Assert.assertTrue(ErrorEmpleado);
       Assert.assertTrue(ErrorLenguaje);
       Assert.assertEquals(NoAgregado.getText(),"Please read and agree to the Master Subscription Agreement");
   }
   // Ejercicio :
   // Completar el método testingErrorMessages: utilizando Fakers, completar el campo de la
   // persona. Luego, hacer click en el botón de “Start free trial”. Validar que el mensaje de
   // error para el email no esté presente.
    @Test (priority = 1)
    public void testingErrorMessages_2(){
        // maximizar
        driver.manage().window().maximize();
        // boton try to free
        driver.findElement(By.id("signup_link")).click();
        // espera de 10 segundos
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         // variables
        Faker faker = new Faker();
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        String titulo= faker.job().title();
        String correo = faker.internet().emailAddress();
        String fono = faker.phoneNumber().cellPhone();
        String compañia = faker.company().name();

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
        Boolean ErrorCorreo= false;
        // lista de mensaje de error
        List<WebElement> MensajeError = driver.findElements(By.className("error-msg"));
         // reorrer la lista
         for(WebElement we:MensajeError){
             if(we.getText().equals("Enter a valid email address")){
                 ErrorCorreo= true;
             }
         }
           // VALIDACION
           Assert.assertFalse(ErrorCorreo);
         System.out.println(ErrorCorreo);

    }
   // Crear un método de test llamado completeSalesforceFormTest
  //  Ingresar a la página https://login.salesforce.com/?locale=eu.
  //  Hacer click en botón Try To Free
  //  Completar la información del registro sin ser el título
   // First Name: John
   // Last Name: Smith
   // Title: Tester
   // Email: test@test.com
   // Phone: 1234123412
   // Dar click en el botón de “Start my free trial”
   // Validar que la información de error mostrada al finalizar, sea la correcta
   // Validar que la información ingresada sea la que se muestra en pantalla
    @Test (priority = 2)
    public void completeSalesforceFormTest(){
        // maximizar
        driver.manage().window().maximize();
        // boton try to free
        driver.findElement(By.id("signup_link")).click();
        // espera de 10 segundos
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // escribir nombre
        driver.findElement(By.name("UserFirstName")).sendKeys("John");
        // escribir apellido
        driver.findElement(By.name("UserLastName")).sendKeys("Smith");
        // escribir titulo
        driver.findElement(By.name("UserTitle")).sendKeys("Tester");
        // escribir correo
        driver.findElement(By.name("UserEmail")).sendKeys("test@test.com");
        // escribor fono
        driver.findElement(By.name("UserPhone")).sendKeys("1234123412");
        // escribir compañia
        driver.findElement(By.name("CompanyName")).sendKeys("AOC");
        // selecionar empleo
        Select empleo = new Select(driver.findElement(By.name("CompanyEmployees")));
        empleo.selectByValue("15");
        // selecion lenguaje compañia
        Select lenguaje = new Select(driver.findElement(By.name("CompanyLanguage")));
        lenguaje.selectByValue("es");
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
        driver.quit();
    }
}
