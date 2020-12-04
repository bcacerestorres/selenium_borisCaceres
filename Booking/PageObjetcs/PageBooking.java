package Booking.PageObjetcs;
import Practico14.DataFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PageBooking {
    protected WebDriver driver;

    public PageBooking(WebDriver aDriver) {
        PageFactory.initElements(aDriver, this);
        driver = aDriver;
    }

    // muestra la lista de links
    public void linksTest() {
        List<WebElement> enlaces = driver.findElements(By.tagName("a"));
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println("la cantidad de enlaces de tipo a  totales:  " + enlaces.size());
        int contador =0;
            for (WebElement enlace : enlaces) {
                if(enlace.getText().isEmpty()== false) {
                    System.out.println("a :  " + enlace.getText());
                    contador ++;
                }
            }
            System.out.println("los enlaces con textos : "+contador);
        System.out.println("----------------------------------------------------------------------\n");
    }
    // muestra la lista de h1
    public void h1Test(){
        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("la cantidad de enlaces  h1 es :  " +h1s.size());
            for (WebElement h1 : h1s) {
                System.out.println(" h1 : "+h1.getText());
            }
        System.out.println("----------------------------------------------------------------------");
    }

    // muestra botones
    public void botones(){
        List<WebElement> Botones = driver.findElements(By.tagName("button"));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("la cantidad de enlaces  botones es :  " +Botones.size());
        int contador =0;
        for (WebElement boton : Botones) {
            if(boton.getText().isEmpty()== false) {
                System.out.println(" boton : " + boton.getText());
                contador++;
            }
        }
        System.out.println("los botones con textos : "+contador);
        System.out.println("----------------------------------------------------------------------");
    }

  // mostrar lista h2
  public List<WebElement> h2Test() {
      List<WebElement> h2s = driver.findElements(By.tagName("h2"));
      System.out.println("----------------------------------------------------------------------");
      System.out.println("la cantidad de enlaces de tipo h2 : " + h2s.size());
      int contador =0;
          for (WebElement h2 : h2s) {
              if(h2.getText().isEmpty()== false) {
                  System.out.println("h2 : " + h2.getText());
                  contador ++;
              }
          }
      System.out.println("los h2 con textos : "+contador);
      System.out.println("----------------------------------------------------------------------");
      return h2s;
  }

  //presionar en inicia sesion
  public void BotonIniciarSesion()  {
      // presionar en inicia sesion
      driver.findElement(By.linkText("Inicia sesión")).click();
  }

// presionar en boton registrate
 public void BotonRegistrate(){
     // presionar el boton registrate
     driver.findElement(By.linkText("Regístrate")).click();
    }

 public String sesion (){
     // insertar mail
     driver.findElement(By.cssSelector("#username")).sendKeys(DataFactory.getCorreo());
     // presionar en siguiente
     driver.findElement(By.xpath("//span[contains(text(),'Siguiente')]")).click();
     // mensaje de error
     WebElement crearCuenta=driver.findElement(By.cssSelector("#username-description"));

     return  crearCuenta.getText();
    }

   public  String registrate(){
       // insertar mail
       driver.findElement(By.cssSelector("#username")).sendKeys(DataFactory.getCorreo());
       // presionar en empezar
       driver.findElement(By.xpath("//span[contains(text(),'Empezar')]")).click();
       //contraseña
       driver.findElement(By.cssSelector("#password")).sendKeys(DataFactory.getClave());
       //confirmar contraseña
       driver.findElement(By.cssSelector("#confirmed_password")).sendKeys(DataFactory.getClave());
       // crear cuenta
       driver.findElement(By.xpath("//span[contains(text(),'Crear una cuenta')]")).click();
       // mensaje de error
       WebElement contrasena= driver.findElement(By.cssSelector("#confirmed_password-description"));

       return contrasena.getText();
   }

  public String empezar(){
      // insertar mail
      driver.findElement(By.cssSelector("#login_name_register")).sendKeys("test@test.com");
      // presionar en empezar
      driver.findElement(By.xpath("//span[contains(text(),'Empezar')]")).click();

      // mensaje inciar sesion
      WebElement inicarSesion =driver.findElement(By.cssSelector("#login_name_register-description"));

        return inicarSesion.getText() ;
    }

}
