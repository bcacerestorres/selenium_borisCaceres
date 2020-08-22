package Practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio11_2 {
   // Crear una clase llamada spotify_test
   //         Ejercicio
  //  Crear un método llamado spotifyByName
  //  Ingresar al sitio: https://www.spotify.com/uy/signup/
   // Completar todos los campos con xpath name

   //         Ejercicio
   // Crear un método llamado spotifyByPlaceHolder
   // Ingresar al sitio: https://www.spotify.com/uy/signup/
   // Completar todos los campos con xpath placeholder

    private WebDriver getDriver(String url) {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        return driver;
    }

    @Test
    public void spotifyByName(){
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testEmiliano112@gmail.com");
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("testEmiliano112@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("holamundo123");
        driver.findElement(By.xpath("//input[@name='displayname']")).sendKeys("holamundo123");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/form/div[6]/div[2]/label[1]/span[2]")).click();
        driver.findElement(By.xpath("//input[@name='day']")).sendKeys("15");

        Select mes = new Select(driver.findElement(By.xpath("//select[@name='month']")));
        mes.selectByIndex(05);
        driver.findElement(By.xpath("//input[@name='year']")).sendKeys("2003");

        WebElement check = driver.findElement(By.xpath("//span[@class='Indicator-sc-11vkltc-0 hrjscC']"));
        check.click();

        driver.findElement(By.xpath("//a[@href=\"/legal/end-user-agreement\"]")).click();
        //driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();

    }
    @Test
    public void spotifyByPlaceHolder (){
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        driver.findElement(By.xpath("//input[@placeholder='Introduce tu correo electrónico.']")).sendKeys("test123444emiliano@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test123444emiliano@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Crea una contraseña.']")).sendKeys("testing123");
        driver.findElement(By.xpath("//input[@placeholder='Introduce un nombre de perfil.']")).sendKeys("testing123");
        driver.findElement(By.xpath("//input[@placeholder='DD']")).sendKeys("15");

        Select mes = new Select(driver.findElement(By.cssSelector("select[name='month']")));
        mes.selectByIndex(05);
        driver.findElement(By.xpath("//input[@placeholder='AAAA']")).sendKeys("2003");

        WebElement genero = driver.findElement(By.xpath("//label[2]//span[1]"));
        genero.click();

        WebElement check = driver.findElement(By.xpath("//span[@class='Indicator-sc-11vkltc-0 hrjscC']"));
        check.click();

    }


}
