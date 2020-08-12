import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio8 {
    WebDriver driver;

    private WebDriver getGoogleDriver(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
         driver = new ChromeDriver();
        String baseUrl = "https://www.google.com";
        driver.get(baseUrl);

        return driver;
    }

    @Test
    public void ejemplo8(){
        getGoogleDriver();
    }


    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
