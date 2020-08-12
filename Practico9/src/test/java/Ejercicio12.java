import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class Ejercicio12 {
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
   public void getBrowserSizes(){

       getDriver("https://www.facebook.com");
       int alto=driver.manage().window().getSize().getHeight();
       int ancho =driver.manage().window().getSize().getHeight();

       System.out.println(alto);
       System.out.println(ancho);

       driver.manage().window().maximize();

       int maxAlto=driver.manage().window().getSize().getHeight();
       int maxAncho=driver.manage().window().getSize().getWidth();

       System.out.println("alto maximo" +maxAlto);
       System.out.println("ancho maximo " +maxAncho);
   }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
