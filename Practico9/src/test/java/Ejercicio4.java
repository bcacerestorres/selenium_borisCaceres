import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.List;
public class Ejercicio4 {
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
    public  void bbcMundoLinks() {
        getDriver("https://www.bbc.com/mundo");
        List<WebElement> referencia = driver.findElements(By.tagName("a"));
        List<WebElement> parrafos = driver.findElements(By.tagName("p"));

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("la cantidad de parrafos es  " + parrafos.size());
        for(WebElement parrafo :parrafos){
            System.out.println(parrafo.getText());
             }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("la cantidad de links es " + referencia.size());
        for(WebElement refe :referencia){
            System.out.println(refe.getText());
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
