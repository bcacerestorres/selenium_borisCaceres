package Practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio11_3 {
    //Ejercicio
  //  Crear un método llamado spotifyByName
   // Ingresar al sitio: https://www.spotify.com/uy/signup/
  //  Completar todos los campos con Css Selector name

   // Crear un método llamado spotifyByPlaceHolder
   // Ingresar al sitio: https://www.spotify.com/uy/signup/
   // Completar todos los campos con Css Selector placeholder

    private WebDriver getDriver(String url) {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        return driver;
    }

    @Test
    public void  spotifyByName(){
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test123444emiliano@gmail.com");
        driver.findElement(By.cssSelector("input[name='confirm']")).sendKeys("test123444emiliano@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("testing123");
        driver.findElement(By.cssSelector("input[name='displayname']")).sendKeys("testing123");
        driver.findElement(By.cssSelector("input[name='day']")).sendKeys("12");

        Select mes = new Select(driver.findElement(By.cssSelector("select[name='month']")));
        mes.selectByIndex(03);
        driver.findElement(By.cssSelector("input[name='year']")).sendKeys("2000");

        WebElement genero = driver.findElement(By.cssSelector("div.signuppage__Signup-sof6g5-0.YsCoj:nth-child(6) form:nth-child(4) div.Group-sc-1lird8m-0.iNEHpO:nth-child(7) div.GenderSelect__FlexRow-v1a8zn-0.fRpOnE label.Radio-fatlcr-0.ioFODN:nth-child(1) > span.Indicator-sc-16vj7o8-0.dDbCKU"));
        genero.click();

        WebElement check = driver.findElement(By.cssSelector("div.signuppage__Signup-sof6g5-0.YsCoj:nth-child(6) form:nth-child(4) div.Group-sc-1lird8m-0.iNEHpO:nth-child(8) label.Checkbox-sc-1141y94-0.fRKYyx > span.Indicator-sc-11vkltc-0.hrjscC"));
        check.click();

    }


    @Test
    public void  spotifyByPlaceHolder(){
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test123444emiliano@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test123444emiliano@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("testing123");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("testing123");
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("13");

        Select mes = new Select(driver.findElement(By.cssSelector("select[name='month']")));
        mes.selectByIndex(04);
        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("2001");

        WebElement genero = driver.findElement(By.cssSelector("div.signuppage__Signup-sof6g5-0.YsCoj:nth-child(6) form:nth-child(4) div.Group-sc-1lird8m-0.iNEHpO:nth-child(7) div.GenderSelect__FlexRow-v1a8zn-0.fRpOnE label.Radio-fatlcr-0.ioFODN:nth-child(1) > span.Indicator-sc-16vj7o8-0.dDbCKU"));
        genero.click();

        WebElement check = driver.findElement(By.cssSelector("div.signuppage__Signup-sof6g5-0.YsCoj:nth-child(6) form:nth-child(4) div.Group-sc-1lird8m-0.iNEHpO:nth-child(8) label.Checkbox-sc-1141y94-0.fRKYyx > span.Indicator-sc-11vkltc-0.hrjscC"));
        check.click();

        //  driver.findElement(By.cssSelector("div[role='presentation']")).click();
        //  driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/form/h2"));

    }


}
