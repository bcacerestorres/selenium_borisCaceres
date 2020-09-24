package Practico15.ejercicio1.PageOjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class SalesforceLandingPage {
    private WebDriver driver;

    public SalesforceLandingPage(WebDriver aDriver){
        PageFactory.initElements(aDriver, this);
        driver = aDriver;
    }
    // login in
    public String loginToSalesforceWithWrongCredentials(){
        driver.findElement(By.id("username")).sendKeys("testsdafasdf@gmail.com");
        driver.findElement(By.id("password")).sendKeys("asdfasdfsa");
        driver.findElement(By.id("Login")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        WebElement errorElement = driver.findElement(By.id("error"));

        return errorElement.getText();
    }

    // use custom domain
    public String UseCustomDomain(){
    //  boton custom domain
        driver.findElement(By.id("mydomainLink")).click();
        //ingreso de caracter
        driver.findElement(By.id("mydomain")).sendKeys("as");
        // boton continuar
        driver.findElement(By.name("Continue")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // texto inciar sesion
        WebElement inicarsesion= driver.findElement(By.xpath("//h2[@class='okta-form-title o-form-head']"));

        return inicarsesion.getText() ;
    }

    // forgot your password
    public  String ForgotYourPassword(){
       // boton
       driver.findElement(By.id("forgot_password_link")).click();
       //username
        driver.findElement(By.id("un")).sendKeys("abc");
        // cancelar
        driver.findElement(By.linkText("Cancel")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // not a customer
        WebElement Nocustomer=driver.findElement(By.xpath("//p[@class='di mr16']"));

        return Nocustomer.getText();
    }

    // try for free
   public void tryforfree(){
        // boton try for fre
        driver.findElement(By.id("signup_link")).click();
        // espera de 10 segundos
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // variables
       Faker faker = new Faker();
       String nombre = faker.name().firstName();
       String apellido = faker.name().lastName();
       String titulo= faker.job().title();
       String correo = faker.internet().emailAddress();
       String fono = faker.phoneNumber().cellPhone();
       String compañia = faker.company().name();

       // escribir nombre
       driver.findElement(By.name("UserFirstName")).sendKeys(nombre);
       // escribir apellido
       driver.findElement(By.name("UserLastName")).sendKeys(apellido);
       // escribir titulo
       driver.findElement(By.name("UserTitle")).sendKeys(titulo);
       // escribir correo
       driver.findElement(By.name("UserEmail")).sendKeys(correo);
       // escribor fono
       driver.findElement(By.name("UserPhone")).sendKeys(fono);
       // escribir compañia
       driver.findElement(By.name("CompanyName")).sendKeys(compañia);
       // selecionar empleo
       Select empleo = new Select(driver.findElement(By.name("CompanyEmployees")));
       empleo.selectByValue("3");
       // selecion lenguaje compañia
       Select lenguaje = new Select(driver.findElement(By.name("CompanyLanguage")));
       lenguaje.selectByValue("en_US");
       // boton star my free trial
       driver.findElement(By.name("Start my free trial")).click();

   }

    public boolean RememberMeIsSelected(){
        //maximizar
        driver.manage().window().maximize();
        //boton check remen
        WebElement recordar = driver.findElement(By.xpath("//input[@id='rememberUn']"));
        recordar.click();
        Boolean selecionado= recordar.isSelected();

       return selecionado;
    }

}

