package Practico10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utilities.GetProperties;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.NoSuchElementException;

public class Ejercicio10_4 {
    //Crear un método de test llamado checkBoxAndComboboxTest
    // Ir a Facebook https://www.facebook.com/
    // Setear el combo para seleccionar el sexo en Custom
    // Mostrar todas las opciones que se despliegan en el nuevo combobox
    // Elegir el tercer valor del combo
    // Completar el custom field con “The”

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
    // provar si existe elemnto por id
    private boolean existsElement(String id) {
        try {
            driver.findElement(By.id(id));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Test
    public void checkBoxAndComboboxTest(){
        getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

        driver.findElement(By.cssSelector("#u_0_2")).click();

        boolean a= existsElement("u_1_6");
        System.out.print("el elemento existe " +a);
        System.out.print("\n");

        WebElement s3= driver.findElement(By.xpath("//input[@value='-1']"));
        s3.click();


        WebElement meses = driver.findElement(By.id("month"));
        Select combo= new Select(meses);
        System.out.print("----------------------------------------------------------\n");
        List<WebElement> opciones= combo.getOptions();
        for(WebElement op: opciones){
            System.out.println(op.getText());
        }
        combo.selectByValue("3");

        System.out.print("----------------------------------------------------------");
        WebElement gender= driver.findElement(By.name("custom_gender"));
        gender.sendKeys("The");
    }

    @AfterTest
    public void closedriver(){
        driver.close();
        driver.quit();
    }


}
