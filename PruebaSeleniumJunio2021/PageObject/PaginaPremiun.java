package PruebaSeleniumJunio2021.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaPremiun {
    // variables locales
    public WebDriver driver;

    //constructor
    public PaginaPremiun(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    // metodo de buscar plan Individual
    public String planIndivual(){
    WebElement  individual=driver.findElement(By.xpath("//h3[contains(text(),'Individual')]"));
   // System.out.println(individual);
    System.out.println(individual.getText());
    return  individual.getText();
    }

    // metodo de buscar plan Duo
    public String planUniversaitario(){
        WebElement  universitario=driver.findElement(By.xpath("//h3[contains(text(),'Universitario')]"));
   //     System.out.println(universitario);
        System.out.println(universitario.getText());
        return  universitario.getText();
    }

    public String planDuo(){
        WebElement  duo=driver.findElement(By.xpath("//h3[contains(text(),'Duo')]"));
   //     System.out.println(duo);
        System.out.println(duo.getText());
        return  duo.getText();
    }


    // metodo de buscare plan Familiar
    public String planFamiliar(){
        WebElement  familiar=driver.findElement(By.xpath("//h3[contains(text(),'Familiar')]"));
   //     System.out.println(familiar);
        System.out.println(familiar.getText());
        return  familiar.getText();
    }

}
