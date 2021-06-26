package PruebaSeleniumJunio2021.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaPrincipal {
    // variables locales
    public WebDriver driver;

    //constructor
    public PaginaPrincipal(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    // metodo presionar en premiun
    public void PresionarPremiun(){
        //presionar en premiun by LinkText Premium
     WebElement EnlacePremiun= driver.findElement(By.linkText("Premium"));
     EnlacePremiun.click();
    }

    // metodo de presionar en registro
    public void PresionarRegistro(){
        //   registrarse  by LinkText Regístrate
     WebElement EnlaceRegistro= driver.findElement(By.linkText("Regístrate"));
        EnlaceRegistro.click();
    }


}
