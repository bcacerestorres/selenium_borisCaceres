package Integracion1.TestIntegracion;
import Integracion1.PageIntegracion.PageIntegracion;
import Practico14.Constans;
import Practico14.DataProviderPeople;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.GetProperties;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestIntegracion {
    protected WebDriver driver;
    PageIntegracion PageIntegracion;

    @BeforeMethod
    public void setup() {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        //  package Practico14 , public class Constans
        // public static String BBC_URL="https://www.bbc.com";
        driver.get(Constans.BBC_URL);
        // maximizar
        driver.manage().window().maximize();
        // metodo de espera implicito
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // iniciar el driver
        PageIntegracion = new PageIntegracion(driver);
    }
    //--------------- escenario 1
   // Validar que el título de la página sea BBC - Homepage
   // Imprimir todos los h1
  //  Imprimir 5 hipervínculos de tipo <a>
  //  Hacer click en News
   // Validar que el título de la página sea Home - BBC News
   // Hacer click en “Register Now”
   // Validar que el título de la página sea BBC – Sign in

    @Test (groups = "grupo1")
    public void escenario1 (){
   // titulo de la pagina
        System.out.println("---------------------------titulo pagina original-------------------------------------------\n");
     String tituloActual=driver.getTitle();
     System.out.println(tituloActual);
     String Tituloesperado= Constans.TITULO;
     Assert.assertEquals(tituloActual,Tituloesperado);

     PageIntegracion.h1Test();
     PageIntegracion.aTest();

      PageIntegracion.EnlaceNew();
      System.out.println("----------------------------titulo pagina new------------------------------------------\n");
      String newActual= driver.getTitle();
      System.out.println(newActual);
      String newEsperado= Constans.TITULO_NEW;
      Assert.assertEquals(newActual,newEsperado);
      System.out.println("----------------------------------------------------------------------\n");

        System.out.println("----------------------------------titulo pagina register------------------------------------\n");
        PageIntegracion.Registernow();
        String registerActual= driver.getTitle();
        System.out.println(registerActual);
        String regiserEsperado= Constans.TITULO_SIGN;
        Assert.assertEquals(registerActual,regiserEsperado);
        System.out.println("----------------------------------------------------------------------\n");

    }
    //Escenario 2
   // Realizar un test que reciba por parámetro un número que represente la opción del menú a
    //ingresar.
 //1 para ingresar a “ News ”
    // 2 para ingresar a “ Sport ”
          //  3 para ingresar a “ Reel ”
           // 4 para ingresar a “ Work Life ”
           // 5 para ingresar a “ Travel ”
 //   La opción se debe poder manejar desde el testng.xml. En caso de que se ejecuten los test
 //   desde la misma clase de test, se debe ingresar a “ Sport ”
 //   Validar el la URL de cada sección luego de haber ingresado a la misma.
    @Test (groups = "grupo1")
    @Parameters ({"menu"})
public void escenario2(@Optional("2") int op){
        System.out.print("---------------------------------------------------------------------------------------");
        System.out.print("\n");
        if(op == 1){
            System.out.print("opciones del menu : New \n");
            PageIntegracion.EnlaceNew();
            System.out.println("Url :"+driver.getCurrentUrl());
            String urlEsperadonew=Constans.BBC_URL_NEW;
            Assert.assertEquals(driver.getCurrentUrl(),urlEsperadonew);

        }else if(op == 3){
            System.out.print("opciones del menu : Reel \n");
            PageIntegracion.EnlaceReel();
            System.out.println("Url :"+driver.getCurrentUrl());
           String urlEsperadoreel=Constans.BBC_URL_REEL;
            Assert.assertEquals(driver.getCurrentUrl(),urlEsperadoreel);

        }else if(op == 4){
            System.out.print("opciones del menu : Worklife \n");
            PageIntegracion.EnlaceWorklife();
            System.out.println("Url :"+driver.getCurrentUrl());
            String urlEsperadowork=Constans.BBC_URL_WORKLIFE;
            Assert.assertEquals(driver.getCurrentUrl(),urlEsperadowork);

        }else if(op == 5){
            System.out.print("opciones del menu : Travel \n");
            PageIntegracion.EnlaceTravel();
            System.out.println("Url :"+driver.getCurrentUrl());
            String urlEsperadotravel= Constans.BBC_URL_TRAVEL;
           Assert.assertEquals(driver.getCurrentUrl(),urlEsperadotravel);

        }else {
            System.out.print("opciones del menu : Sport \n");
            PageIntegracion.EnlaceSport();
            System.out.println("Url :"+driver.getCurrentUrl());
            String urlEsperadosport= Constans.BBC_URL_SPORT;
            Assert.assertEquals(driver.getCurrentUrl(),urlEsperadosport);
        }


}
   // Escenario 3
    //Hacer click en “ Register Now ”
    //Hacer click en “ Under 16 ”
    //Validar que el texto desplegado sea “ Sorry, only 16s and over can register outside the UK”
    ///Hacer click en Ok
    //Validar que se vuelva a la página principal
@Test(groups ="grupo1")
public void escenario3(){
    PageIntegracion.Registernow();
    PageIntegracion.under16();

   String mensajeUnder = PageIntegracion.Mensajesorry();
   String esperado= Constans.MENSAJE_SORRY;
   Assert.assertEquals(mensajeUnder,esperado);

   PageIntegracion.Bontonok();

   Assert.assertEquals(driver.getCurrentUrl(),Constans.BBC_URL);

}
   // Escenario 4
  //  Hacer click en “ Register Now ”
  //  Hacer click en “ 16 or over ”
  //  Completar el campo del Mes
  //  Hacer click en continuar
   // Validar que el mensaje de error sea “Oops, that day and year don't look right. Make sure
  //  it's a real date written as DD-MM-YYYY e.g. the 5th of June 2009 is 05-06-2009.”
@Test(groups ="grupo1")
public void escenario4(){
    PageIntegracion.Registernow();

    PageIntegracion.Over16();

    PageIntegracion.mes();
    PageIntegracion.continuar();
    String mensajeBirth = PageIntegracion.Nomes();
    String esperadoBirth= Constans.MENSAJE_BIRTH;
    Assert.assertEquals(mensajeBirth,esperadoBirth);
}
   // Escenario 5
   // Hacer click en “ Register Now ”
  //  Hacer click en “ 16 or over ”
   // Completar el día del Día 12, Mes 12, Año 2019
   // Hacer click en continuar
   // Validar que el mensaje de error sea “ Sorry, you need to be 16 or over.”
@Test(groups = "grupo2")
public void escenario5(){
    PageIntegracion.Registernow();

    PageIntegracion.Over16();

    PageIntegracion.completarfecha();
    PageIntegracion.botonContinuar();

    String mensajeFecha= PageIntegracion.sorryFecha();
    String esperado= Constans.MENSAJE_OVER;
    Assert.assertEquals(mensajeFecha,esperado);

}
   // Escenario 6
  //  Hacer click en “ Register Now ”
  //  Hacer click en “ 16 or over ”
  //  Completar el día del Día 15, Mes 2, Año 2000
  //  Hacer click en continuar
  //  Completar el correo electrónico con test@test.com
  //  Completar la contraseña con holamundo123
  //  Seleccionar el país Taiwan
@Test (groups = "grupo2")
public void escenario6(){
    PageIntegracion.Registernow();
    PageIntegracion.Over16();

    PageIntegracion.completarfecha2();
    PageIntegracion.botonContinuar();
    PageIntegracion.Datos();

}
   // Escenario 7
 //   Hacer click en “ Register Now ”
 //   Hacer click en “ 16 or over ”
 //   Completar el día del Día 15, Mes 2, Año 200
 //   Hacer click en continuar
   //   Utilizar un data loader para cargar diferentes emails y contraseñas válidas.
@Test(groups = "grupo2",dataProviderClass =DataProviderPeople .class,dataProvider= "credenciales")
//(dataProviderClass =DataProviderPeople .class, dataProvider="email")
public void escenario7(String mail , String clave){
    PageIntegracion.Registernow();
    PageIntegracion.Over16();

    PageIntegracion.completarfecha2();
    PageIntegracion.botonContinuar();

    driver.findElement(By.cssSelector("#user-identifier-input")).sendKeys(mail);
    driver.findElement(By.cssSelector("#password-input")).sendKeys(clave);

}

    @AfterMethod
    public void close() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
