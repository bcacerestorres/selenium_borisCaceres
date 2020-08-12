import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.List;

public class Ejercicio3 {
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
    public void bbcMundo(){
           getDriver("https://www.bbc.com/mundo");

        List<WebElement> elementoh1= driver.findElements(By.tagName("h1"));
        List<WebElement> elementoh2= driver.findElements(By.tagName("h2"));
        List<WebElement> elementoh3= driver.findElements(By.tagName("h3"));

        System.out.println("---------------------------------------------------------------------------");
           System.out.println(" elementos h1");
        System.out.println(" el numero de elemetos h1  es "+elementoh1.size());
             for(WebElement h1: elementoh1){
                 System.out.println(h1.getText());
             }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" elementos h2");
        System.out.println(" el numero de elemetos h2  es "+elementoh2.size());
        for(WebElement h2: elementoh2){
            System.out.println(h2.getText());
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" elementos h3");
        System.out.println(" el numero de elemetos h3  es "+elementoh3.size());
        for(WebElement h3: elementoh3){
            System.out.println(h3.getText());
        }
        System.out.println("---------------------------------------------------------------------------");

        driver.manage().window().maximize();
        driver.navigate().refresh();

    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
