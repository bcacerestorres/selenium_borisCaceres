package Practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.GetProperties;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class Ejercicio11_4 {
   // Acceder  a www.gmail.com
  //  Hacer click en “Acceder a tu cuenta en su lugar”
  //  Mostrar la cantidad de span que tiene

   private WebDriver getDriver(String url) {
       GetProperties properties = new GetProperties();
       String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
       System.setProperty("webdriver.chrome.driver", chromeDriverUrl);

       WebDriver driver = new ChromeDriver();

       driver.get(url);
       return driver;
   }

    @Test
   public void ContarSpan(){
       WebDriver driver = getDriver("https://www.gmail.com");

        driver.manage().window().maximize();

       driver.findElement(By.cssSelector("input[name='identifier']")).sendKeys("bcacere53");

        driver.findElement(By.xpath("//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']")).click();

       WebElement mensaje=driver.findElement(By.xpath("//div[contains(text(),'Correo electrónico o teléfono')]"));
        System.out.println(""+mensaje.getText());

       List<WebElement> etiquetaSpan= driver.findElements(By.tagName("span"));
       System.out.println("---------------------------------------------------------------------------");
       System.out.println(" elementos span");
       System.out.println(" el numero de elemetos span  es "+etiquetaSpan.size());
       for(WebElement span: etiquetaSpan){
           System.out.println(span.getText());
       }
        System.out.println("---------------------------------------------------------------------------");
   }


}