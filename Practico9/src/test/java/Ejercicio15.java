import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.List;

public class Ejercicio15 {
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
    public void inicarNexflix(){
        getDriver("https://www.netflix.com/uy/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Iniciar sesión")).click();

    List<WebElement> h1s = driver.findElements(By.tagName("h1"));
    List<WebElement> h2s = driver.findElements(By.tagName("h2"));
    System.out.println("---------------------------------------------------------------------------");
    System.out.println(" elementos h1");
    System.out.println(" el numero de elemetos h1  es "+h1s.size());
    for(WebElement h1: h1s){
        System.out.println(h1.getText());
    }

    System.out.println("---------------------------------------------------------------------------");
    System.out.println(" elementos h2");
    System.out.println(" el numero de elemetos h2  es "+h2s.size());
    for(WebElement h2: h2s){
        System.out.println(h2.getText());
    }

    driver.navigate().back();

    driver.navigate().refresh();

    List<WebElement> divs  = driver.findElements(By.tagName("div"));
    System.out.println("---------------------------------------------------------------------------");
    System.out.println(" la cantidad de elementos tipo div " +divs.size());
    for(WebElement div: divs){
        System.out.println(div.getText());
    }
    System.out.println("---------------------------------------------------------------------------");
    System.out.println(" el titulo de la pagina es "+driver.getTitle());

    List<WebElement> inputs = driver.findElements(By.tagName("input"));
    List<WebElement> links = driver.findElements(By.tagName("link"));
    System.out.println("---------------------------------------------------------------------------");
    System.out.println(" la cantidad de elementos tipo input " +inputs.size());
    System.out.println(" la cantidad de elementos tipo links " +links.size());
    System.out.println("---------------------------------------------------------------------------");

    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
