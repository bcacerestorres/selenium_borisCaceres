package pruebas_netflix.PageNetflix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pruebas_netflix.FabricadaDatos;

import java.util.ArrayList;
import java.util.List;

public class PageNetflix {
    protected WebDriver driver;

    // constructor
    public PageNetflix(WebDriver aDriver) {
        PageFactory.initElements(aDriver, this);
        driver = aDriver;
    }

    //Hacer click en Iniciar Sesión.
    public void iniciarSesion() {
        driver.findElement(By.linkText("Iniciar sesión")).click();
    }

    // h1
    public void h1Test() {
        int contador = 0;
        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("la cantidad de enlaces  h1 es :  " + h1s.size());
        for (WebElement h1 : h1s) {
            if (h1.getText().isEmpty() == false) {
                System.out.println(" h1 : " + h1.getText());
                contador++;
            }
        }
        System.out.println("los  h1 con textos : " + contador);
        System.out.println("----------------------------------------------------------------------");
    }

    // h1 buscar
    public void buscarh1(){
        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("la cantidad de enlaces  h1 es :  " + h1s.size());
        for (WebElement h1 : h1s) {
            if (h1.getText().equals("Inicia Sesión")) {
                System.out.println(" h1 : " + h1.getText());

            }
        }
        System.out.println("----------------------------------------------------------------------");
    }

    //texto faceobok

    public String textoFacebook(){
    WebElement textobuscado= driver.findElement(By.xpath("//span[@class='fbBtnText']"));
    return textobuscado.getText();
    }

    // completar datos email y contrasela
    public void completar(){
    driver.findElement(By.id("id_userLoginId")).sendKeys("test@test.com");
    driver.findElement(By.id("id_password")).sendKeys("holamundo");
    }


  // boton recurdame
    public void disclear(){
     driver.findElement(By.xpath("//div[@class='ui-binary-input login-remember-me']//label")).click();
    }
 // boton inicar sesion para registrarme
public void ingresar(){
   driver.findElement(By.className("btn login-button btn-submit btn-small")).click();
}

// mensaje de error
  public String mensajeContraseña(){
     WebElement mensjasecontraseña=driver.findElement(By.xpath("//a[contains(text(),'restablece la contraseña.')]"));
   return mensjasecontraseña.getText();
    }
//
public boolean noClick(){
    WebElement selecionado =driver.findElement(By.xpath("//div[@class='ui-binary-input login-remember-me']//label"));
    return selecionado.isSelected();
}

// mail
    public void correo(){
    driver.findElement(By.id("id_email_hero_fuji")).sendKeys(FabricadaDatos.getCorreo());
    }

    // comienza ya
    public void comienzaya(){
    driver.findElement(By.xpath("//div[@class='our-story-card hero-card hero_fuji vlv']//span[@class='cta-btn-txt'][contains(text(),'COMIENZA YA')]")).click();
    }

}
