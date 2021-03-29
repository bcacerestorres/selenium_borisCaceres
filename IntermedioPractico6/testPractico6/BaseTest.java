package IntermedioPractico6.testPractico6;

//import ecommerceSite.pageObject.AuthenticationPage;
import IntermedioPractico6.pageObjectPractico6.AuthenticationPage;
//import ecommerceSite.pageObject.LandingPage;
import IntermedioPractico6.pageObjectPractico6.LandingPage;
//import ecommerceSite.pageObject.MyAccountPage;
import IntermedioPractico6.pageObjectPractico6.MyAccountPage;
//import ecommerceSite.pageObject.NewAccountPage;
import IntermedioPractico6.pageObjectPractico6.NewAccountPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.GetProperties;
import java.util.concurrent.TimeUnit;

// clase base test
public class BaseTest {

    String URL = "http://automationpractice.com/index.php";
    public WebDriver driver;

    // metodo de inicio
    @BeforeMethod
    public void setup() {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        PageFactory.initElements(driver, this);
    }
// metodo de registro usuario
    protected MyAccountPage registerAnUser(String myEmail, String fakeFirstName, String fakeLastName) throws InterruptedException {
        //se puede mejorar....
        LandingPage landingPage = new LandingPage(driver);
        AuthenticationPage authenticationPage = landingPage.clickOnLoginBtn();
        authenticationPage.validateAuthPage();

        NewAccountPage newAccountPage = authenticationPage.createEmailOfTheAccount(myEmail);

        Thread.sleep(2000);
        return newAccountPage.fillingPersonalInfoForm(fakeFirstName, fakeLastName);
    }

// metodo de cierre
    @AfterMethod
    public void closeDriver() throws InterruptedException{
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("Se ha terminado de ejecutar un test...");
        Thread.sleep(4000);
        driver.close();
    }
}
