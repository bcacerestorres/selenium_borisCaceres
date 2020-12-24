package pruebas_netflix.TestNetflix;

import pruebas_netflix.Constantes;
import pruebas_netflix.FabricadaDatos;
import pruebas_netflix.PageNetflix.PageNetflix;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pruebas_netflix.ProveedorDatos;
import utilities.GetProperties;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNetflix {
    protected WebDriver driver;
    PageNetflix  PageNetflix;
    private  int param;

  // public Fabrica (){
  //      this.param=0;
  //  }
    // constructor con parametro
  //  public Fabrica (int unparam){
  //     this.param=unparam;
  //  }

    @BeforeMethod
    public void setup() {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();

        driver.get(Constantes.URL_NETFLIX);
        // maximizar
        driver.manage().window().maximize();
        // metodo de espera implicito
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // iniciar el driver
        PageNetflix = new PageNetflix(driver);
    }

    //Crear un test llamado validarTituloTest, que valide el título de la página con un assert.
    @Test(groups = "exito" , priority = 5)
    public void validarTituloTest(){
     String tituloActual= driver.getTitle();
      System.out.println("titulo actual  :"+tituloActual);
      String tituloEsperado= Constantes.TITULO;
      System.out.println("titulo esperado  :"+tituloEsperado);
      Assert.assertEquals(tituloActual,tituloEsperado);
    }
// Crear un método de test que se llame iniciarSesionPageTest.
  @Test(groups = "fallo" , priority = 4)
  public void  iniciarSesionPageTest(){
      PageNetflix.iniciarSesion();
      PageNetflix.h1Test();
      PageNetflix.buscarh1();

      System.out.println("----------------------------------------------------------------------");
      String textofacebook = PageNetflix.textoFacebook();
      System.out.println("texto facebook :"+textofacebook);
      String TextoEsperado= Constantes.TEXTO_FACEBOOK;
      System.out.println("texto facebook :"+textofacebook);
      System.out.println("----------------------------------------------------------------------");

      String tituloSecion =driver.getTitle();
      System.out.println("titulo sesion  :"+tituloSecion);
      String tituloEsperado= Constantes.TITULO;
      System.out.println("titulo esperado   :"+tituloEsperado);
      Assert.assertEquals(tituloSecion,tituloEsperado);
      System.out.println("----------------------------------------------------------------------");

  }

   //Crear un método de test llamado loginToNetflixErrorTest que complete el campo del
    @Test(groups = "fallo" , priority = 3)
    public void loginToNetflixErrorTest(){
        PageNetflix.iniciarSesion();
        PageNetflix.completar();
        PageNetflix.disclear();
        PageNetflix.ingresar();

        String mensajeValidacion = PageNetflix.mensajeContraseña();
        System.out.println("mensaje  :"+mensajeValidacion);
        String mensajeEsperado= Constantes.MENSAJE;
        System.out.println("mensaje esperado   :"+mensajeEsperado);
        boolean click = PageNetflix.noClick();
        Assert.assertEquals(mensajeValidacion, mensajeEsperado);

    }

    // Crear un método llamado fakeEmailTest que ingrese “Iniciar Sesión. Hacer click en que
   @Test(groups = "exito" , priority = 2)
    public void fakeEmailTest(){
    PageNetflix.correo();
    PageNetflix.comienzaya();
    }

    //Crear un método llamado dataProviderEmailTest que ingrese “Iniciar Sesión” y
    // complete el campo de email y haga click en COMIENZA YA. El dataProvider debe enviar 3 emails al test.
    @Test (groups = "exito",priority = 1 ,dataProviderClass = ProveedorDatos.class,dataProvider= "email")
    public void dataProviderEmailTest(String correo){
        driver.findElement(By.id("id_email_hero_fuji")).sendKeys(correo);
        PageNetflix.comienzaya();
    }

    @AfterMethod
    public void close() throws InterruptedException{
        Thread.sleep(5000);
    //    driver.quit();
    }

}
