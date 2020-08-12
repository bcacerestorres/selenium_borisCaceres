import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.concurrent.TimeUnit;

public class Ejercicio9 {
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
    public void ejemplo9(){
       getDriver("https://www.lun.com");
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
