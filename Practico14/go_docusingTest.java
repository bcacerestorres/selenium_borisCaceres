package Practico14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class go_docusingTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(Constans.GO_DOCUSIGN_URL);
    }
    @Test
    public void completeRegistrationFormTest(){
        WebElementHelper elementos = new WebElementHelper(driver);
        //nombre
       // driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(DataFactory.getNombre());
        elementos.setXpath("input","name","first_name",DataFactory.getNombre());
        //apellido
       // driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(DataFactory.getApellido());
        elementos.setXpath("input","name","last_name",DataFactory.getApellido());
        // email
        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(DataFactory.getCorreo());
        elementos.setXpath("input","name","email",DataFactory.getCorreo());
        // telefono
      //  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(DataFactory.getTelefono());
        elementos.setXpath("input","name","phone",DataFactory.getTelefono());
        // titulo trabajo
      //  driver.findElement(By.xpath("//input[@name='title']")).sendKeys(DataFactory.getTrabajo());
        elementos.setXpath("input","name","title",DataFactory.getTrabajo());
        // selecion industria
        Select industria = new Select(driver.findElement(By.xpath("//select[@name='ds_industry']")));
        industria.selectByValue("Technology");
        // boton de registro
       driver.findElement(By.id("submitMainText_0")).click();
        // titulo luego de  registro
       System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"DocuSign Free Trial");
    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
