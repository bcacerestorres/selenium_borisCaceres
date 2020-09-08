package Practico13;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class go_docusign {
    WebDriver driver;
    private static String GO_DOCUSING_URL = "https://go.docusign.com/o/trial/";

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(GO_DOCUSING_URL);
    }
  //  Ejercicio
  //  Entrar al sitio https://go.docusign.com
   // Obtener todos los h1
   // Validar que al menos uno contenga el texto: “Try DocuSign free for 30 days”
    @Test (priority = 0)
    public void obtenerh1(){
   // lista de h1
        List<WebElement>  elementosh1= driver.findElements(By.tagName("h1"));
        ArrayList<WebElement> h1encontrado= new ArrayList<WebElement>();
        System.out.println("Elementos h1 \n");
        for(WebElement we: elementosh1){
            if(we.getText().equals("Try DocuSign free for 30 days") == true){
                h1encontrado.add(we);
            }
        }
        WebElement elementoh1 =h1encontrado.get(0);
        System.out.println(elementoh1.getText());
        Assert.assertEquals(elementoh1.getText(),"Try DocuSign free for 30 days");
    }
   // Ejercicio
   // Crear un método llamado testEmptyFields
   // Entrar al sitio https://go.docusign.com/o/trial/
   // Hacer click en el botón de registro
   // Validar que se muestran los mensajes de error

    @Test (priority = 1)
    public void testEmptyFields () {
        // boton de registro
        driver.findElement(By.id("submitMainText_0")).click();
        //mensaje no nombre
        WebElement NONombre = driver.findElement(By.xpath("//*[contains(text(),'First name required')]"));
        Assert.assertEquals(NONombre.getText(), "First name required");
        // mensaje no appellido
        WebElement NOApellido = driver.findElement(By.xpath("//*[contains(text(),'Last name required')]"));
        Assert.assertEquals(NOApellido.getText(), "Last name required");
        //mensaje no email
        WebElement NOEmail = driver.findElement(By.xpath("//*[contains(text(),'Valid email address required.')]"));
        Assert.assertEquals(NOEmail.getText(), "Valid email address required.");
        // mensaje no telefono
        WebElement NOTelefono = driver.findElement(By.xpath("//*[contains(text(),'Valid phone # required')]"));
        Assert.assertEquals(NOTelefono.getText(), "Valid phone # required");
        // mensaje titulo no trabajo
        WebElement NOTrabajo = driver.findElement(By.xpath("//*[contains(text(),'Job title required')]"));
        Assert.assertEquals(NOTrabajo.getText(), "Job title required");

        //mensaje no insdustria
        Select industria = new Select(driver.findElement(By.xpath("//select[@name='ds_industry']")));
        List<WebElement> opciones = industria.getOptions();
        System.out.println(" se seleciono alguna opcion");
        System.out.println(opciones.equals("Select One"));

        WebElement NOIndustria = driver.findElement(By.xpath("//*[contains(text(),'Select an industry')]"));
       Assert.assertEquals(NOIndustria.getText(),"Select an industry");
    }
  //  Ejercicio
  //  Crear un método llamado completeRegistrationForm
  //  Entrar al sitio https://go.docusign.com/o/trial/
  //  Completar todos los campos del formulario
  @Test (priority = 2)
  public void completeRegistrationForm(){
      //nombre
      driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Pablo");
      //apellido
      driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("lara");
      // email
      driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testing@gmail.com");
      // telefono
      driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("94220003");
      // titulo trabajo
      driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Analista Funcional");
      // selecion industria
      Select industria = new Select(driver.findElement(By.xpath("//select[@name='ds_industry']")));
      industria.selectByValue("Technology");
      // boton de registro
      driver.findElement(By.id("submitMainText_0")).click();
      // titulo luego de  registro
      System.out.println(driver.getTitle());
      Assert.assertEquals(driver.getTitle(),"DocuSign Free Trial");
  }
    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
       driver.quit();
    }

}
