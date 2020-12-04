package Integracion1.PageIntegracion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;

public class PageIntegracion {
    protected WebDriver driver;

    public PageIntegracion(WebDriver aDriver){
        PageFactory.initElements(aDriver, this);
        driver = aDriver;
    }

    // muestra la lista de h1
    public void h1Test(){
        int contador =0;
        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("la cantidad de enlaces  h1 es :  " +h1s.size());
        for (WebElement h1 : h1s) {
            if(h1.getText().isEmpty()== false) {
                System.out.println(" h1 : " + h1.getText());
                contador++;
            }
        }
        System.out.println("los  h1 con textos : "+contador);
        System.out.println("----------------------------------------------------------------------");
    }
  // muestra 5 links
    public void aTest() {
        List<WebElement> enlaces = driver.findElements(By.tagName("a"));
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println("la cantidad de enlaces de tipo a  totales:  " + enlaces.size());
        for (int i=0; i<6;i++)
        {
            if(enlaces.get(i).getText().isEmpty()== false) {
                System.out.println(" a : " + enlaces.get(i).getText());
            }
        }
        System.out.println("----------------------------------------------------------------------\n");
    }

    // boton new  1
    public void EnlaceNew(){

        driver.findElement(By.linkText("News")).click();
    }

   // boton register
    public void Registernow(){
       driver.findElement(By.cssSelector("#idcta-username")).click();

       driver.findElement(By.linkText("Register now")).click();
    }

    // boton sport 2
    public void EnlaceSport(){
    driver.findElement(By.linkText("Sport")).click();
    }

    // boton reel 3
    public void EnlaceReel(){
    driver.findElement(By.linkText("Reel")).click();
    }

    //boton workile 4
    public void EnlaceWorklife(){
   driver.findElement(By.linkText("Worklife")).click();
    }

    // boton travel 5
    public void EnlaceTravel(){
    driver.findElement(By.linkText("Travel")).click();
    }

    // boton under 16
    public void under16(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // esa expresion me permitio identificador el elemento
      //  WebElement element = driver.findElement(By.xpath("//a[@class='button' and @data-bbc-result='/register/details/guardian']"));
      WebElement element= driver.findElement(By.xpath("//body/div[@id='orbit-container-full-height']/div[@id='orb-modules']/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/fieldset[1]/div[1]/a[1]"));
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", element);
       element.click();
    }
    // mensaje sory
    public String mensajeSorry(){
        WebElement mensaje= driver.findElement(By.xpath("//span[contains(text(),'Sorry, only 16s and over can register outside the ')]"));
        return mensaje.getText();
    }

    // boton ok
    // JavascriptExecutor es una interfaz que ayuda a ejecutar java script
    // faltaba tiempo para el elemento aparesca
    public void bontonOk(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement boton = driver.findElement(By.xpath("//body/div[@id='orbit-container-full-height']/div[@id='orb-modules']/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/a[1]"));
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",boton);
        boton.click();
    }

    //boton 16 or over
    // faltaba tiempo para el elemento aparesca
    public void Over16(){
    WebDriverWait myWaitVar = new WebDriverWait(driver, 30);
     myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a//span[contains(text(),'16 or over')]")));

      WebElement elemento = driver.findElement(By.xpath("//a//span[contains(text(),'16 or over')]"));
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",elemento);

        //para hacer click sobre el boton , ya que aveces indica que el elemento no esta presente
          try {
              elemento.click();
          }
          catch (StaleElementReferenceException e){
              driver.get(driver.getCurrentUrl());
              elemento = driver.findElement(By.xpath("//a//span[contains(text(),'16 or over')]"));
               jse =(JavascriptExecutor)driver;
             jse.executeScript("arguments[0].click()",elemento);
              elemento.click();
         }

    }

    // ingresar mes
    public void mes(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//input[@id='month-input']")).sendKeys("12");
    }

    public  void continuar(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement seguir =driver.findElement(By.xpath("//button[@id='submit-button']"));
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",seguir);
        seguir.click();
    }

    // mensaje de mes
    public String Nomes(){
    WebElement mensaje = driver.findElement(By.xpath("//div[@id='form-message-dateOfBirth']"));
    return mensaje.getText();
    }

    // completar fecha 12/12/2019
    public void completarfecha(){
     driver.findElement(By.xpath("//input[@id='day-input']")).sendKeys("12");
     driver.findElement(By.xpath("//input[@id='month-input']")).sendKeys("12");
     driver.findElement(By.xpath("//input[@id='year-input']")).sendKeys("2019");
    }

    // boton continuar
    public void botonContinuar(){
     driver.findElement(By.xpath("//button[@id='submit-button']")).click();
    }

    // mensaje de sory birth

    public String sorryFecha(){
        WebElement mensajeFecha = driver.findElement(By.xpath("//span[contains(text(),'Sorry, you need to be 16 or over.')]"));
        return mensajeFecha.getText();
    }

    // completar fecha 15/2/2000
    public void completarfecha2(){
        driver.findElement(By.cssSelector("#day-input")).sendKeys("15");
        driver.findElement(By.cssSelector("#month-input")).sendKeys("2");
        driver.findElement(By.cssSelector("#year-input")).sendKeys("2000");
    }

    // comletar correo , passwor , pais
    public void datosFormulario(){
     driver.findElement(By.cssSelector("#user-identifier-input")).sendKeys("test@test.com");
     driver.findElement(By.cssSelector("#password-input")).sendKeys("holamundo123");

     WebElement pais =driver.findElement(By.cssSelector("#location-select"));
     Select comboPais= new Select(pais);
     comboPais.deselectByVisibleText("Taiwan");

    }


}
