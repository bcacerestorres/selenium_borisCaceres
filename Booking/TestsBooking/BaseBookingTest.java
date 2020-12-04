package Booking.TestsBooking;
import Practico14.Constans;
import Booking.PageObjetcs.BookingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.GetProperties;
import java.util.concurrent.TimeUnit;

public class BaseBookingTest {
    protected WebDriver driver;
    BookingPage  BookingPage;

    @BeforeMethod
    public void setup() {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(Constans.BOOKING_URL);
        // maximizar
        driver.manage().window().maximize();
        // metodo de espera implicito
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // iniciar el driver
        BookingPage = new BookingPage(driver);
    }
    @AfterMethod
    public void close() throws InterruptedException{
        Thread.sleep(5000);
     //   driver.quit();
    }
}
