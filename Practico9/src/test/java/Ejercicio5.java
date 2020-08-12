import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.List;

public class Ejercicio5 {
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
    public void bbcMundoListas(){
        getDriver("https://www.bbc.com/mundo");

        List<WebElement> listas=driver.findElements(By.tagName("li"));
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("la cantidad de li " + listas.size());
        for(WebElement lista :listas){
            System.out.println(lista.getText());
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
