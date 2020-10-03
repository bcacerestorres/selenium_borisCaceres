package Booking.PageObjetcs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class BaseBookingPage {
    protected WebDriver driver;

    public BaseBookingPage(WebDriver aDriver) {
        PageFactory.initElements(aDriver, this);
        driver = aDriver;
    }
}
