package Practico10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ejercicio10_10 {

    // Completar los campos de registro de facebook, utilizando el atributo className.

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


        List<WebElement> nombre1= driver.findElements(By.className("inputtext _58mg _5dba _2ph-"));
        System.out.println("numero de elmentos "+nombre1.size());
        System.out.println(" esta vacio"+nombre1.isEmpty());

        WebElement nombre= driver.findElement(By.cssSelector("input[name='firstname']"));
        nombre.sendKeys("John");

        WebElement apellido= driver.findElement(By.cssSelector("input[name='lastname']"));
        apellido.sendKeys("Smith");

        WebElement correo= driver.findElement(By.cssSelector("input[name='reg_email__']"));
        correo.sendKeys("5555555");

        WebElement contraseña= driver.findElement(By.cssSelector("input[name='reg_passwd__']"));
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
