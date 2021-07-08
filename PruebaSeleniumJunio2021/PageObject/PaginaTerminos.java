package PruebaSeleniumJunio2021.PageObject;

import PruebaSeleniumJunio2021.Constantes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PaginaTerminos{
    // variables locales
    public WebDriver driver;
    //constructor
    public PaginaTerminos(WebDriver remoteDriver){
        driver = remoteDriver;
    }

  // listo de enlaces
   public List<WebElement> Enlaces() {
        List<WebElement> enlace = driver.findElements(By.tagName("a"));
       // numeros de elmentos de la lista form
       System.out.println("-------------------------------enlace-----------------------");
       System.out.println("numero de enlace " +enlace.size());
       System.out.println("\n");
        for(WebElement a:enlace){
            System.out.println("texto enlace " +a.getText());
            System.out.println("\n");
        }
      return enlace;
   }

   // buscar Disfrutando Spotify
    public  Boolean buscarDisfrutar(){
        // variable bandera
        boolean banderea1 = false;
        List<WebElement>disfruta=Enlaces();
        for(WebElement d:disfruta){
            if(d.getText().equals("Disfrutando Spotify")){
                banderea1 = true;
            }// fin if
        } // fin for
        System.out.println("bandera1 es "+banderea1);
        return  banderea1;
    }// fin public

    // buscar Pagos, cancelaciones y periodo de reflexión
    public  Boolean buscarPagos(){
        // variable bandera
        boolean banderea2 = false;
        List<WebElement>disfruta=Enlaces();
        for(WebElement d:disfruta){
            if(d.getText().equals("Pagos, cancelaciones y periodo de reflexión")){
                banderea2 = true;
            }// fin if
        } // fin for
        System.out.println("bandera2 es "+banderea2);
        return  banderea2;
    }// fin public

    // buscar Uso de nuestro servicio
    public  Boolean buscarServicios(){
        // variable bandera
        boolean banderea3 = false;
        List<WebElement>disfruta=Enlaces();
        for(WebElement d:disfruta){
            if(d.getText().equals("Uso de nuestro servicio")){
                banderea3 = true;
            }// fin if
        } // fin for
        System.out.println("bandera3 es "+banderea3);
        return  banderea3;
    }// fin public

}
