package Integracion2.PageIntegracion2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageIntegracion2 {
    protected WebDriver driver;

// contructor
    public PageIntegracion2(WebDriver aDriver){
        PageFactory.initElements(aDriver, this);
        driver = aDriver;
    }

// boton my acount
    public void botonMyacount(){
        driver.findElement(By.linkText("My Account")).click();
    }

// boton resgister
    public void botonRegister(){
      driver.findElement(By.linkText("Register")).click();
    }

// registro
    public void formulario(){
     driver.findElement(By.id("input-firstname")).sendKeys("Raul");
     driver.findElement(By.id("input-lastname")).sendKeys("Mardones");
     driver.findElement(By.id("input-email")).sendKeys("figo858@hotmail.com");
     driver.findElement(By.id("input-telephone")).sendKeys("930040019");
     driver.findElement(By.id("input-password")).sendKeys("alo123");
     driver.findElement(By.id("input-confirm")).sendKeys("alo123");

     driver.findElement(By.xpath("//body//label[2]")).click();

     driver.findElement(By.name("agree")).click();

     driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

    }

// boton login
    public void botonLogin(){
      driver.findElement(By.linkText("Login")).click();
    }

    // credenciales
    public void credenciales(){
        driver.findElement(By.id("input-email")).sendKeys("figo858@hotmail.com");
        driver.findElement(By.id("input-password")).sendKeys("alo123");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

    }

    // logout
    public void salir(){
      driver.findElement(By.linkText("Logout")).click();
    }

    //mensaje de warnig
    public String mensajeWarning(){
        WebElement mensaje1= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        return mensaje1.getText();
    }

    //mensaje your store
    public String mensajeStore(){
     WebElement mensaje2= driver.findElement(By.xpath("//a[contains(text(),'Your Store')]"));
     return mensaje2.getText();
    }

    //mensaje de logout
    public String mensajeAccount(){
     WebElement mensaje3 = driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
     return mensaje3.getText();
    }

    // buscar mac
    public void buscar (){
     driver.findElement(By.name("search")).sendKeys("Mac");
     driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
    }

    // mensaje de productos
    public String mensajeBUSCAR(){
    WebElement mensaje4= driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']"));
    return mensaje4.getText();
    }

    // buscar samsung
    public void buscarSangung (){
        driver.findElement(By.name("search")).sendKeys("Samsung Galaxy Tab 10.1");
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
    }

    // agregar a carro
    public void agregarCarro(){
     driver.findElement(By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]")).click();
    }

    // mensaje agregar a carro
    public String mensajeAgregar(){
      WebElement mensaje5= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
      return mensaje5.getText();
    }

    //costo
    public void Costos(){
     driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
    driver.findElement(By.xpath("//strong[contains(text(),'View Cart')]")).click();
    }

    // mensaje de costo
    public String mensajeCosto(){
     WebElement mensaje6 = driver.findElement(By.xpath("//div[@class='table-responsive']//td[@class='text-right'][contains(text(),'$483.98')]"));
     return  mensaje6.getText();
    }

    //mensaje de no match
    public String mensajeLogin(){
    WebElement mensaje7=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
    return mensaje7.getText();
    }

}
