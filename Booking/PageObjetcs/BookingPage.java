package Booking.PageObjetcs;
import Booking.PageObjetcs.BaseBookingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;

public class BookingPage extends BaseBookingPage{

    public BookingPage(WebDriver aDriver) {
        super(aDriver);
    }

public void mostrarEnlace(){
    List<WebElement> enlaces = driver.findElements(By.tagName("a"));
    System.out.println("la cantidad de enlaces " +enlaces.size());
    for(WebElement enlace: enlaces){
        System.out.println("Elemento: " + enlace.getText());
    }
  }


}
