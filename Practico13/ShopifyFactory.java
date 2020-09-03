package Practico13;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GetProperties;
import java.util.ArrayList;
import java.util.List;

public class ShopifyFactory {
    // Crear una clase llamada ShopifyTest y una clase llamada ShopifyFactory.
    //  ShopifyTest debe tener una variable de clase privada de tipo int
    //  También, debe contar con un constructor que reciba un valor por parámetro, y setee esa
    //   variable con ese valor.
    //   La clase ShopifyTest debe tener un constructor que reciba y setee ese parámetro. El
    //   constructor sin parámetros, debe setear el parámetro en 0.
    //  El @beforeMethod debe acceder a  "https://es.shopify.com/"
    //  Agregar un método de test llamado testButtons que obtenga todos los botones de la página,
    //  e imprima en pantalla el texto del botón que coincide con el parámetro.

    // atributo
    private  int param;
    WebDriver driver;
    private static String Shopify_URL = "https://es.shopify.com/";

    public ShopifyFactory (){
        this.param=0;
    }
    // constructor con parametro
    public ShopifyFactory (int unparam){
        this.param=unparam;
    }

    @BeforeMethod
    public void setup(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(Shopify_URL);
    }
    @Test
    public void testButtons(){
        //   lista de botones
        List<WebElement> webElementList =driver.findElements(By.tagName("button"));
        // array de no elementos
        ArrayList<WebElement> NoBotones= new ArrayList<WebElement>();
        //impresiones
        for(WebElement we : webElementList){
            if(we.getText().equals("")== false){
                NoBotones.add(we);
            }
        }

        WebElement botonParam = NoBotones.get(param);
        System.out.println(botonParam.getText());
    }

    @AfterMethod
    public void closedriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
