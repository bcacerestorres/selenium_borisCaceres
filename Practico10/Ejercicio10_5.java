package Practico10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.util.concurrent.TimeUnit;

public class Ejercicio10_5 {
    // Crear un método de test llamado checkBoxTest
    // Ir a Facebook https://www.facebook.com/
    // Validar que no haya valor seleccionado en el checkbox Gender
    // Mostrar un mensaje en pantalla y agregar un assert para validar que no esta seleccionado
    // Hacer click en el checkbox de Male
    // Mostrar si esta seleccionado
    // Agregar un assert que valide que realmente esté seleccionado

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

    @Test
    public void checkBoxTest(){
        getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;

        driver.findElement(By.cssSelector("#u_0_2")).click();

        WebElement genero =  driver.findElement(By.name("sex"));
        System.out.print("----------------------------------------------------------\n");
        System.out.print("se seleciono el elemento :\n");
        System.out.println(genero.isSelected());
        Assert.assertTrue(!genero.isSelected());

        System.out.print("----------------------------------------------------------\n");
        WebElement masculino= driver.findElement(By.xpath("//input[@value='2']"));
        masculino.click();
        System.out.print("se seleciono el elemento :\n");
        System.out.println(masculino.isSelected());
        Assert.assertTrue(masculino.isSelected());
        System.out.print("----------------------------------------------------------\n");
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
