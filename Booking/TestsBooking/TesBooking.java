package Booking.TestsBooking;
import Booking.PageObjetcs.BookingPage;
import Booking.PageObjetcs.PageBooking;
import Practico14.Constans;
import Practico14.DataFactory;
import Practico14.DataProviderPeople;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.GetProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;

public class TesBooking {
    protected WebDriver driver;
    PageBooking PageBooking;

    @BeforeMethod
    public void setup() {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(Constans.BOOKING_URL);
        // maximizar
        driver.manage().window().maximize();
        // metodo de espera implicito
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // iniciar el driver
        PageBooking = new PageBooking(driver);
    }
   // Crear un test llamado validarTituloTest, que valide el título de la página con un assert.
    @Test (priority = 0)
   public  void validarTituloTest(){
     System.out.println(driver.getTitle());
     Assert.assertEquals(driver.getTitle(),"Booking.com | Web oficial | Los mejores hoteles y alojamientos");
    }

    @Test (priority = 1)
    //Crear un test llamado mostarLinksTest. Crear un test que muestre los links presentes en el sitio
   public void mostarLinksTest(){
       PageBooking.linksTest();
       System.out.println("----------------------------------------------------------------------\n");
        PageBooking.botones();
        System.out.println("----------------------------------------------------------------------\n");

    }

   // Crear un test llamado mostarH1sTest. Mostrar los h1s que estén presentes en el sitio
   @Test (priority = 2)
  public void mostarH1sTest(){

        PageBooking.h1Test();
   }
   //Crear un test llamado buscarGenteViajeraTest que busque en todos los h2s,
   // si el texto “Conecta con gente viajera” está presente. (Utilizar un assert para validarlo)
    // use de base ejercicio10_7 ,practic0 13 go_docusign
   @Test (priority = 3)
   public void buscarGenteViajeraTest(){
        String msg="Conecta con gente viajera";
       List<WebElement> linksH2= PageBooking.h2Test();
       ArrayList<WebElement> h2encontrado= new ArrayList<WebElement>();
       System.out.println("----------------------------------------------------------------------");
       System.out.println("Elementos h2 \n");
       for(WebElement we:linksH2){
           if(we.getText().equals(msg) == true){
               h2encontrado.add(we);
           }
       }
       WebElement elementoh2 =h2encontrado.get(0);
       System.out.println(elementoh2.getText());
       Assert.assertEquals(elementoh2.getText(),msg);
       System.out.println("----------------------------------------------------------------------");
   }
     //  11. Crear un test llamado registroUsuarioTests
   // a. Hacer click en “Inicia Sesión”. Ingrese un email generado desde la clase Faker,
     // haga click en Siguiente. Luego, valide con un assert,
     // que el mensaje de error sea “Parece que no existe ninguna cuenta vinculada a este e-mail.
     // Puedes crear una cuenta para utilizar nuestros servicios.”

   // b. A continuación debe hacer click en el link en el link “Registrate”.
  //  c. Luego, ingresar un email randomico (generado de la librería Fakers)
     //  y hacer click en “Empezar”
  //  d. Ingresar  dos contraseñas que sean diferentes.
     //  e. Validar que se despliegue un mensaje de error: “Las contraseñas no coinciden.
     //  Inténtalo de nuevo”.

    // uso de base practic 15  salesforcetest , salesforcelandindpage
    @Test (priority = 4)
    public void registroUsuarioTests(){
        System.out.println("--------------------------------------------------------------------------");
        String mensajeesperado="Parece que no existe ninguna cuenta vinculada a este e-mail. Puedes crear una cuenta para utilizar nuestros servicios.";
        PageBooking.BotonIniciarSesion();
        String mensajeactual =PageBooking.sesion();
        System.out.println(mensajeactual);
        Assert.assertEquals(mensajeactual,mensajeesperado);

        System.out.println("---------------------------------------------------------------------------");

      String mensajeRegitratre="Las contraseñas no coinciden. Inténtalo de nuevo.";
        PageBooking.BotonRegistrate();
      String mensajeResgistrateactual =PageBooking.registrate();
      System.out.println(mensajeResgistrateactual);
      Assert.assertEquals(mensajeResgistrateactual,mensajeRegitratre);

        System.out.println("--------------------------------------------------------------------------------");
    }
   // Crear un test llamado crearCuentaTest. test@test.com. Hacer click en empezar y validar que
   // el mensaje de error sea “Ya tienes una cuenta de Booking.com registrada con
   // la dirección de e-mail test@test.com. Puedes iniciar sesión directamente.”
   @Test (priority = 5)
   public void crearCuentaTest(){
       System.out.println("---------------------------------------------------------------------------");
       String msgSesion="Ya tienes una cuenta de Booking.com registrada con la dirección de e-mail test@test.com. Puedes iniciar sesión directamente.";
       PageBooking.BotonIniciarSesion();
       PageBooking.BotonRegistrate();
      String msgActual= PageBooking.empezar();
      System.out.println(msgActual);
      Assert.assertEquals(msgActual,msgSesion);
       System.out.println("---------------------------------------------------------------------------");
    }

    @Test (priority = 6,dataProviderClass =DataProviderPeople.class, dataProvider="email")
    public void IniciarCoreos(String mail){
        PageBooking.BotonIniciarSesion();
        // insertar mail
        driver.findElement(By.cssSelector("#username")).sendKeys(mail);
        // presionar en siguiente
        driver.findElement(By.xpath("//span[contains(text(),'Siguiente')]")).click();
        // mensaje de error
        WebElement CorreoInvalido=driver.findElement(By.cssSelector("#username-description"));

        System.out.println(CorreoInvalido.getText());

        String mensajeesperado="Comprueba si el e-mail que has introducido es correcto";

        Assert.assertEquals(CorreoInvalido.getText(),mensajeesperado);

    }

    @AfterMethod
    public void close() throws InterruptedException{
        Thread.sleep(5000);
          driver.quit();
    }

}
