import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejercicio14 {
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
    public void netflixPagina(){
        getDriver("https://www.netflix.com/uy/");
        driver.manage().window().maximize();

        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        List<WebElement> h2s = driver.findElements(By.tagName("h2"));
        List<WebElement> h3s = driver.findElements(By.tagName("h3"));
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

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" elementos h3");
        System.out.println(" el numero de elemetos h3  es "+h3s.size());
        for(WebElement h3: h3s){
            System.out.println(h3.getText());
        }

        driver.navigate().refresh();

        List<WebElement> botones = driver.findElements(By.tagName("button"));
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("botones ");
        System.out.println(" la cantidad de elementos botones " +botones.size());
        for(WebElement boton : botones){
            System.out.println(boton.getText());
        }

        driver.manage().window().maximize();

        List<WebElement> divs  = driver.findElements(By.tagName("div"));
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" la cantidad de elementos tipo div " +divs.size());

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" el titulo de la pagina es "+driver.getTitle());


        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        List<WebElement> links = driver.findElements(By.tagName("link"));
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" la cantidad de elementos tipo input " +inputs.size());
        System.out.println(" la cantidad de elementos tipo links " +links.size());
        System.out.println("---------------------------------------------------------------------------");


        int[] numerosElementos =new int[7];
        numerosElementos[0]=h1s.size();
        numerosElementos[1]=h2s.size();
        numerosElementos[2]=h3s.size();
        numerosElementos[3]=botones.size();
        numerosElementos[4]=divs.size();
        numerosElementos[5]=inputs.size();
        numerosElementos[6]=links.size();

        System.out.println("Vector con los numeros de elementos sin ordenar");
        System.out.println(Arrays.toString(numerosElementos));
        System.out.println("Vector con los numeros de elementos ordenado");
        Arrays.sort(numerosElementos);
        System.out.println(Arrays.toString(numerosElementos));

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" la  mayor cantidad de elemtos son tipo div " +divs.size());
        System.out.println("---------------------------------------------------------------------------");
    }


    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }

}
