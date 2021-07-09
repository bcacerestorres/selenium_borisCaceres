package PruebaSeleniumJunio2021;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.GetProperties;
import java.util.concurrent.TimeUnit;

import PruebaSeleniumJunio2021.PageObject.PaginaPrincipal;
import  PruebaSeleniumJunio2021.PageObject.PaginaPremiun;
import  PruebaSeleniumJunio2021.PageObject.PaginaRegistro;
import  PruebaSeleniumJunio2021.PageObject.PaginaTerminos;

public class spotityTest {
    public WebDriver driver;
    SoftAssert softAssert;
    PaginaPrincipal principal;
    PaginaPremiun premiun;
    PaginaRegistro registro;
    PaginaTerminos terminos;

    //------------------------------------scenario 1
    @Given("estoy en la pagina de spotify")
    public void estoy_en_la_pagina_de_spotify() {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        // carga url
        driver.get(Constantes.Url1);
        //maximizar
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // inicalizamos la pages
        PageFactory.initElements(driver, this);
    }

    @When("Presiono en premiun")
    public void presiono_en_premiun() {
        principal = new PaginaPrincipal(driver);
        principal.PresionarPremiun();
    }

    @Then("validos planes Individual")
    public void validos_planes_individual() {
     premiun = new PaginaPremiun(driver);
     String actual =premiun.planIndivual();
        SoftAssert softAssert = new SoftAssert();
      softAssert.assertEquals(actual,"Individual","el caracter esperado es plan individual");
        softAssert.assertAll();
    }

    @Then("validos planes premium")
    public void validos_planes_premium() {
        premiun = new PaginaPremiun(driver);
        String actual2 =premiun.planUniversaitario();
        String actual3= premiun.planDuo();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual2,"Premiun","el caracter esperado es plan premiun");
        softAssert.assertEquals(actual3,"Premiun","el caracter esperado es plan premiun");
        softAssert.assertAll();
    }

    @Then("validos planes familiar")
    public void validos_planes_familiar() {
        premiun = new PaginaPremiun(driver);
        String actual4 =premiun.planFamiliar();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual4,"Familiar","el caracter esperado es plan familiar");
        softAssert.assertAll();
    }
  /////////////////////////////////////////////////////////
    //---------------------- scenario2
  @When("presiono en registrarme")
  public void presiono_en_registrarme() {
      principal = new PaginaPrincipal(driver);
      principal.PresionarRegistro();
  }

    @When("ingreso correso ")
    public void ingreso_correso() {
      registro = new PaginaRegistro(driver);
      registro.correoVacio();

    }

    @When("ingreso correso fff")
    public void ingreso_correso_fff() {
        registro = new PaginaRegistro(driver);
        registro.correoff();
    }

    @When("ingreso correso test@test.com")
    public void ingreso_correso_test_test_com() {
        registro = new PaginaRegistro(driver);
        registro.correoExistente();
    }

    @Then("valido mensajes Es necesario que introduzcas tu correo electrónico.")
    public void valido_mensajes_es_necesario_que_introduzcas_tu_correo_electrónico() {
        registro = new PaginaRegistro(driver);
        String mensaje1=registro.MensajeVacio();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mensaje1,Constantes.MensajeVacio,"el mensaje para mail vacio no corresponde");
        softAssert.assertAll();
    }

    @Then("valido mensajes Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com")
    public void valido_mensajes_este_correo_electrónico_no_es_válido_asegúrate_de_que_tenga_un_formato_como_este_ejemplo_email_com() {
        registro = new PaginaRegistro(driver);
        String mensaje2=registro.Mensajeff();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mensaje2,Constantes.MensajeNoformato,"el mensaje para formato incorecto de correo no funciona");
        softAssert.assertAll();
    }

    @Then("valido mensajes Este correo electrónico ya está conectado a una cuenta. Inicia sesión.")
    public void valido_mensajes_este_correo_electrónico_ya_está_conectado_a_una_cuenta_inicia_sesión() {
        registro = new PaginaRegistro(driver);
        String mensaje3=registro.MensajeExistente();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mensaje3,Constantes.MensajeExistente,"el mensaje para formato de correo existe no corresponde");
        softAssert.assertAll();
    }

    //////////////////////////////////////////////////////////////////
    //---------------------------------------------scenario 3
    @Given("estar en sitio de terminos y condiciones")
    public void estar_en_sitio_de_terminos_y_condiciones() {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        // carga url
        driver.get(Constantes.URL2);
        //maximizar
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // inicalizamos la pages
        PageFactory.initElements(driver, this);
    }

    @When("buscar enlaces")
    public void buscar_enlaces() {
  terminos = new PaginaTerminos(driver);
   terminos.buscarDisfrutar();
        SoftAssert softAssert = new SoftAssert();
     boolean termino1= terminos.buscarDisfrutar();
     softAssert.assertTrue(termino1," no se encontro el elemento");
     System.out.println(" TERMINOS1 "+termino1);
        softAssert.assertAll();

    }

    @Then("validar algunos enlaces")
    public void validar_algunos_enlaces() {
        terminos = new PaginaTerminos(driver);

        SoftAssert softAssert = new SoftAssert();

        boolean termino1= terminos.buscarDisfrutar();
        softAssert.assertTrue(termino1," no se encontro el elemento");
        System.out.println(" TERMINOS1 "+termino1);

        boolean termino2= terminos.buscarPagos();
        softAssert.assertTrue(termino2,"no se encontro los pagos");
        System.out.println("terminos2 : "+termino2);

        boolean termino3= terminos.buscarServicios();
        softAssert.assertTrue(termino3,"no se encontro los servicios");
        System.out.println("terminos3 : " +termino3);

        softAssert.assertAll();

        driver.close();
    }

}
