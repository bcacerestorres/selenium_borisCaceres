package Practico15.Iframe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.GetProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class iFramesTest {
    private static String SPOTIFY_URL = "https://www.telefonica.com/es/";
    private final String DIFFERENT_EMAILS_ERROR_MSG = "Las direcciones de correo electrónico no coinciden.";
    private final String REGISTERED_EMAIL_ERROR_MSG = "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.";
    private static final String SET_EMAIL_ERROR = "Es necesario que introduzcas tu correo electrónico.";

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testIFrames() throws InterruptedException {

        driver.findElement(By.xpath("//*[@href='/web/shareholders-investors']")).click();
        //Thread.sleep(10000);
        driver.findElement(By.id("aceptar")).click();
        WebElement iframeTelefonica = driver.findElement(By.id("euroland-ticker-es"));

        driver.switchTo().frame(iframeTelefonica);

        //WebElement e = driver.findElement(By.className("Tabxxxxx"));
        List<WebElement> tabs = driver.findElements(By.className("Tab"));

        //Thread.sleep(8000);

        for (WebElement tab : tabs) {
            System.out.println(tab.getText());
            if (tab.getText().equals("NYSE")){
                tab.click();
            }
        }
        WebElement e = driver.findElement(By.className("Tab_Active"));
        Assert.assertEquals(e.getText(), "NYSE");

        List<WebElement> dataItems = driver.findElements(By.className("DataItem"));
        List<WebElement> dataValues = driver.findElements(By.className("DataValue"));

        for (WebElement items : dataItems) {
            System.out.println("---> " + items.getText());
        }

        for (WebElement value : dataValues) {
            System.out.println("       " + value.getText());
        }
    }


    @AfterMethod
    public void close(){
        // driver.quit();
    }
}

