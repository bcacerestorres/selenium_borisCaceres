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

public class Ejercicio10_8 {
//  Crear un método privado llamado setBirthdate que reciba como parámetro el driver, el dia, el
    //   mes y la fecha. Debe setear la fecha de nacimiento de la persona que está completando el
    //  formulario. Utilizar el método en la clase completeRegistration

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
        nombre.sendKeys("Armando");

        WebElement apellido= driver.findElement(By.name("lastname"));
        apellido.sendKeys("Luna");

        WebElement correo= driver.findElement(By.name("reg_email__"));
        correo.sendKeys("test@yahoo.es");

        WebElement contraseña= driver.findElement(By.id("password_step_input"));
        contraseña.sendKeys("1230556");

        setBirthdate(driver,"16","ago","1961");

        WebElement femenino= driver.findElement(By.xpath("//input[@value='1']"));
        femenino.click();
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
