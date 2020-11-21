package Integracion2.TestIntegracion2;
import Integracion1.PageIntegracion.PageIntegracion;
import Practico14.Constans;
import Practico14.DataProviderPeople;
import Integracion2.PageIntegracion2.PageIntegracion2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.GetProperties;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestIntegracion2 {
    protected WebDriver driver;
    PageIntegracion2 PageIntegracion2;

    @BeforeMethod
    public void setup() {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();

        driver.get(Constans.URL_OPENCART);
        // maximizar
        driver.manage().window().maximize();
        // metodo de espera implicito
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // iniciar el driver
        PageIntegracion2 = new PageIntegracion2(driver);
    }

   //1 - Crear una cuenta con un correo y contraseña a elección. Luego desloguearse y volver a
    //  loguearse.
    @Test(groups ="registration")
    public void escenario1(){
        // registro
     PageIntegracion2.botonMyacount();
     PageIntegracion2.botonRegister();
     PageIntegracion2.formulario();

     String mensajeRegistro= PageIntegracion2.mensajeWarning();
     String esperadoR = Constans.MENSAJE_WARNIG;
     Assert.assertEquals(mensajeRegistro,esperadoR);

     // login
    PageIntegracion2.botonLogin();
     // credencias
       PageIntegracion2.credenciales();

        String mensajeLogin= PageIntegracion2.mensajeStore();
        String esperadoL = Constans.MENSAJE_STORE;
        Assert.assertEquals(mensajeLogin,esperadoL);

      //logout
     PageIntegracion2.salir();

     String mensajeAccount=PageIntegracion2.mensajeAccount() ;
     String esperadoA=Constans.MENSAJE_ACCOUNT;
     Assert.assertEquals(mensajeAccount,esperadoA);
    }

    // 2-Realizar una búsqueda de productos Mac y validar que se muestran 4 productos. Se debe
    //estar logueado para realizar una compra.
    @Test(groups ="purchase")
    public void escenario2(){
        PageIntegracion2.botonMyacount();
        PageIntegracion2.botonLogin();

        PageIntegracion2.credenciales();

        PageIntegracion2.buscar();

        String mensajeBuscar=PageIntegracion2.mensajeBUSCAR();
        String esperadoB=Constans.MENSAJE_BUSCAR;
        Assert.assertEquals(mensajeBuscar,esperadoB);

    }

    //3- Buscar y agregar dos tablet Samsung Galaxy Tab 10.1 al carrito y validar que aparezca un
    //mensaje de indicando que el producto se ha agregado al carrito:
    //Success: You have added Samsung Galaxy Tab 10.1 to your shopping cart !
    @Test(groups ="purchase")
   public void escenario3(){
       PageIntegracion2.buscarSangung();
       PageIntegracion2.agregarCarro();
       PageIntegracion2.agregarCarro();

       String mensajeAgregar = PageIntegracion2.mensajeAgregar();
       System.out.println(mensajeAgregar);
       String esperadoAgregar= Constans.MENSAJE_AGREGAR;
       Assert.assertEquals(mensajeAgregar,esperadoAgregar);

   }

   //4- Ir al carrito de compras y validar que el importe del carrito es 483.98 dólares
    @Test(groups ="purchase")
   public void escenario4(){
        PageIntegracion2.buscarSangung();
        PageIntegracion2.agregarCarro();
        PageIntegracion2.agregarCarro();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageIntegracion2.Costos();

        String mensajeCostos = PageIntegracion2.mensajeCosto();
        System.out.println(mensajeCostos);
        String esperadoCostos= Constans.Costo;
        Assert.assertEquals(mensajeCostos,esperadoCostos);

   }
    @Test(groups ="registration",dataProviderClass =DataProviderPeople .class,dataProvider= "cuentas")
   public void escenario5(String mail , String clave){
        PageIntegracion2.botonMyacount();
        PageIntegracion2.botonLogin();

        driver.findElement(By.id("input-email")).sendKeys(mail);
        driver.findElement(By.id("input-password")).sendKeys(clave);
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        String mensajeCredenciales = PageIntegracion2.mensajeLogin();
        System.out.println(mensajeCredenciales);
        String esperadoCredenciales =Constans.MENSAJE_CREDENCIALES;
        Assert.assertEquals(mensajeCredenciales,esperadoCredenciales);

   }


    @AfterMethod
    public void close() throws InterruptedException{
        Thread.sleep(5000);
       driver.quit();
    }


}
