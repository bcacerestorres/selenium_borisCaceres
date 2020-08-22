package Practico11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio11_1 {
  //  Crear una clase llamada docusign_test. Crear un método llamado setBaseURL() que cree una
   // instancia del driver y lo retorne usando el sitio “https://go.docusign.com/o/trial”

   // Crear un método llamado completeDocusignRegistrationForm
   // Ingresar al sitio: https://go.docusign.com/o/trial/
   // Completar todos los campos con xpath name

   // Crear un método llamado defaultxPath
   // Ingresar al sitio: https://go.docusign.com/o/trial/
   // Completar todos los campos usando el xpath sugerido por el explorador

    private WebDriver getDriver(String url) {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        return driver;
    }

    @Test
    public void completeDocusignRegistrationForm(){
        WebDriver driver = getDriver("https://go.docusign.com/o/trial/");
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Jhon");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("12341234");
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Arq.");

        Select industry = new Select(driver.findElement(By.xpath("//select[@name='ds_industry']")));
        industry.selectByValue("Education");
    }

    @Test
    public void defaultxPath(){
        WebDriver driver = getDriver("https://go.docusign.com/o/trial/");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_First_Name\"]/input")).sendKeys("Alan");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Last_Name\"]/input")).sendKeys("Roth");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Email\"]/input")).sendKeys("test3333@test.net");
        // faltan campos phone, jobs ,industry
        WebElement phone= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/section[2]/div/div/div/div/div/div[2]/form/div[1]/label[4]/input"));
        phone.sendKeys("920010013");

        WebElement job= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/section[2]/div/div/div/div/div/div[2]/form/div[1]/label[5]/input"));
        job.sendKeys("Inge");

        Select industria = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/section[2]/div/div/div/div/div/div[2]/form/div[1]/label[6]/select")));
        industria.selectByValue("Technology");
    }
}
