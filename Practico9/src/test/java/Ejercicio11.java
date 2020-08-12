import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio11 {
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
    public void searchInGoogleAndGoBack(){
        getDriver("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("selenium driver"+ Keys.ENTER);

        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
