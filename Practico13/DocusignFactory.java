package Practico13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class DocusignFactory {
  //  Ejercicio
  //  Crear una clase llamada DocusignFactory y una clase llamada DocusignFactoryTest.
   // DocusignFactoryTest debe acceder al sitio “https://go.docusign.com/o/trial/” y debe tener un
  //  método de test que valide que el título de Docusign sea “DocuSign Free Trial”
    WebDriver driver;
    private static String Docusign_URL = "https://go.docusign.com/o/trial/";

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(Docusign_URL);
    }
    @Test
    public void DocusignFactoryTest(){
        driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"DocuSign Free Trial");
    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
      driver.quit();
    }

}
