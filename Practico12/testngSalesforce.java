package Practico12;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class testngSalesforce {
    WebDriver driver;
    private static String SALESFORCE_URL = "https://login.salesforce.com/?locale=eu";
   private static String ELEMENTOALT="Salesforce";
   private static String ElEMENTOAG="logo";

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);
    }
  //  Ejercicio1
  //  Crear un método llamado validateSalesforceLogo
  //  El test debe mostrar el tagName del id logo en pantalla y su atributo “alt’
  //  El orden de prioridad de este test, debe ser 1
    @Test  (enabled = false)
     public void validateSalesforceLogo(){
    //maximizar
    driver.manage().window().maximize();
    //elemento logo
        WebElement logo= driver.findElement(By.id("logo"));
        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
     // alt
     String alt =logo.getAttribute("alt");
     System.out.println("Value de alt: "+alt);
     System.out.print("---------------------------------------------------------------------------------------");
     System.out.print("\n");
     Assert.assertEquals(alt,ELEMENTOALT);
     //name
     String tagname= logo.getAttribute("name");
     System.out.println("Value de name: "+tagname);
     System.out.print("---------------------------------------------------------------------------------------");
     Assert.assertEquals(tagname,ElEMENTOAG);

    }
    //Ejercicio2
   // Crear un método llamado RememberMeIsSelected
   // Ingresar al sitio: https://login.salesforce.com/?locale=eu
   // Hacer click en el botón de Remember me
   // Validar que el checkbox está seleccionado
    //El orden de prioridad de este test, debe ser 4

    @Test  (enabled = false)
    public void RememberMeIsSelected(){
       //maximizar
        driver.manage().window().maximize();
        //boton check remen
        WebElement recordar = driver.findElement(By.xpath("//input[@id='rememberUn']"));
        recordar.click();
         Boolean selecionado= recordar.isSelected();

             if (selecionado)
             {
            System.out.println("Checkbox esta selecionada");
             }else
            {
            System.out.println("Checkbox no esta selecionadado");
             }

         Assert.assertTrue(selecionado);

    }
    //Ejercicio 3
   // Método FooterIsValid
   // Validar que el footer tenga “All rights reserved”
   // El orden de prioridad de este test, debe ser 2
    @Test (priority = 2)
     public void FooterIsValid(){
     //maximizar
     driver.manage().window().maximize();
     // footer
     WebElement footer=driver.findElement(By.xpath("//div[@id='footer']"));
     String textofooter= footer.getText();
     String contenga="All rights reserved";
     System.out.print("---------------------------------------------------------------------------------------");
     System.out.print("\n");
     System.out.print("texto del footer "+textofooter);
     System.out.print("\n");
     System.out.print("contenga  "+contenga);
     System.out.print("\n");
     System.out.print("---------------------------------------------------------------------------------------");
     Assert.assertTrue(textofooter.contains(contenga));
     }
    //Ejercicio 4
   // Crear un método llamado Método LoginFailureTest
   // En el sitio de salesforce: "https://login.salesforce.com/?locale=eu"
   // Validar que se encuentre el logo en el sitio (utilizar un WebElement)
   // Completar el username con “test@test.com”
  //  Completar el campo Password con “123466”
  //  Hacer click en Login
  //  Imprimir en pantalla el mensaje de error
  //  El orden de prioridad de este test, debe ser 3
    @Test  (priority = 3)
     public void LoginFailureTest(){
        //maximizar
        driver.manage().window().maximize();
        //elemento logo
        WebElement logo= driver.findElement(By.id("logo"));
        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        //name
        String tagname= logo.getAttribute("name");
        System.out.println("Value de name: "+tagname);
        System.out.print("---------------------------------------------------------------------------------------");
        Assert.assertEquals(tagname,ElEMENTOAG);
        // username
        driver.findElement(By.id("username")).sendKeys("test@test.com");
        // password
        driver.findElement(By.id("password")).sendKeys("123466");
        // login
        driver.findElement(By.id("Login")).click();
        //mensaje error
        WebElement mensajeNoCuenta = driver.findElement(By.xpath("//*[contains(text(),'Your access to salesforce.com has been disabled by your System Administrator.')]"));
        String mensajeResultado=mensajeNoCuenta.getText();
        String contenga= "Your access to salesforce.com has been disabled by your System Administrator.";
        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        System.out.print("elemento  : "+mensajeResultado);
        System.out.print("\n");
        Assert.assertTrue(mensajeResultado.contains(contenga));

     }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
      driver.quit();
    }

}
