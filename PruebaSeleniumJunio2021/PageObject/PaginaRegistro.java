package PruebaSeleniumJunio2021.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaRegistro {
    // variables locales
    public WebDriver driver;

    //constructor
    public PaginaRegistro(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    //metodo de ingreso de correo vacio
    public void correoVacio(){
     //   mail  by id, name es  email
     WebElement vacio= driver.findElement(By.id("email"));
     vacio.sendKeys("");
     vacio.sendKeys(Keys.ENTER);
    }

    public String  MensajeVacio(){
        // xpath //span[@class='LinkContainer-sc-1t58wcv-0 gUjKMh']
        WebElement mensacevacio= driver.findElement(By.xpath("//span[@class='LinkContainer-sc-1t58wcv-0 gUjKMh']"));
       System.out.println(mensacevacio);
        System.out.println(mensacevacio.getText());
        return  mensacevacio.getText();
    }

    //metodo de ingreso de correo ffff
    public void correoff(){
        //   mail  by  id , name ,email
        WebElement ff= driver.findElement(By.id("email"));
        ff.sendKeys("ffff");
        ff.sendKeys(Keys.ENTER);
    }

    public String  Mensajeff(){
        // xpath //span[@class='LinkContainer-sc-1t58wcv-0 gUjKMh']
        WebElement mensaceff= driver.findElement(By.xpath("//span[@class='LinkContainer-sc-1t58wcv-0 gUjKMh']"));
        System.out.println(mensaceff);
        System.out.println(mensaceff.getText());
        return  mensaceff.getText();
    }

    //metodo de ingreso de correo ffff
    public void correoExistente(){
        //   mail  by id, name es  email
        WebElement existente= driver.findElement(By.id("email"));
        existente.sendKeys("test@test.com");
        existente.sendKeys(Keys.ENTER);
    }

    public String  MensajeExistente(){
        // xpath //span[@class='LinkContainer-sc-1t58wcv-0 gUjKMh']
        WebElement mensaceExistente= driver.findElement(By.xpath("//span[@class='LinkContainer-sc-1t58wcv-0 gUjKMh']"));
        System.out.println(mensaceExistente);
        System.out.println(mensaceExistente.getText());
        return  mensaceExistente.getText();
    }

}
