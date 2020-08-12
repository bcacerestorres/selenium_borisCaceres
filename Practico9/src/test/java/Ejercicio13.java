import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.List;
public class Ejercicio13 {
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
    public void facebookPageTest(){
        getDriver("https://www.facebook.com");

        List<WebElement> divs = driver.findElements(By.tagName("div"));
        List<WebElement> href = driver.findElements(By.tagName("a"));
        List<WebElement> botones = driver.findElements(By.tagName("button"));

        System.out.println(" la cantidad de elementos tipo divs son " +divs.size());
        System.out.println(" la cantidad de elementos tipo  a  son " +href.size());
        System.out.println(" la cantidad de elementos tipo botones son " +botones.size());

        System.out.println(" textos de tipo a ");
        for(WebElement a : href){
          System.out.println(a.getText());
        }

        System.out.println("botones ");
        for(WebElement b : botones){
            System.out.println(b.getText());
        }

    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
