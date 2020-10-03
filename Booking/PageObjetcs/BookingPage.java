package Booking.PageObjetcs;
import Booking.PageObjetcs.BaseBookingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class BookingPage extends BaseBookingPage{
    public BookingPage(WebDriver aDriver) {
        super(aDriver);
    }

public void obtenerEnlace(){
    List<WebElement> enlaces = driver.findElements(By.tagName("a"));
    System.out.println("la cantidad de enlaces " +enlaces.size());
    for(WebElement enlace: enlaces){
        System.out.println("Elemento: " + enlace.getText());
    }
  }


}
