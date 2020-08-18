package Practico10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.util.concurrent.TimeUnit;

public class Ejercicio10_9 {
    //  Crear un método de test llamado completeRegistration
    //   Ir a Facebook https://www.facebook.com/
    //   Completar todos los campos:
//    First Name: “John”
    //   Last Name: “Smith”
//    Mobile: “5555555”
    //   New Password: “123456789”
    //   Birthday: Jun 26 1980
    //   Gender Female

    WebDriver driver;

    private WebDriver getDriver(String url){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        String baseUrl = url;
        driver.get(baseUrl);

        return driver;
    }

    private void setBirthdate(WebDriver driver , String Undia,String Unmes, String Unaño){
        WebElement dias= driver.findElement(By.id("day"));
        Select comboDia = new Select (dias);
        comboDia.selectByVisibleText(Undia);

        WebElement mes= driver.findElement(By.id("month"));
        Select comboMes = new Select (mes);
        comboMes.selectByVisibleText(Unmes);

        WebElement año= driver.findElement(By.id("year"));
        Select comboAño = new Select (año);
        comboAño.selectByVisibleText(Unaño);
    }

    @Test
    public void completeRegistration(){
        getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();



        driver.findElement(By.cssSelector("#u_0_2")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;

        WebElement nombre= driver.findElement(By.name("firstname"));
        nombre.sendKeys("John");

        WebElement apellido= driver.findElement(By.name("lastname"));
        apellido.sendKeys("Smith");

        WebElement correo= driver.findElement(By.name("reg_email__"));
        correo.sendKeys("5555555");

        WebElement contraseña= driver.findElement(By.id("password_step_input"));
        contraseña.sendKeys("123456789");

        setBirthdate(driver,"26","jun","1980");

        WebElement femenino= driver.findElement(By.xpath("//input[@value='1']"));
        femenino.click();
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
