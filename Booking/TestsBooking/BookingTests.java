package Booking.TestsBooking;
import Booking.PageObjetcs.BookingPage;
import Booking.TestsBooking.BaseBookingTest;
import Booking.PageObjetcs.BaseBookingPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTests extends BaseBookingTest  {
    @Test
   public void  validarTituloTest(){
      String titulo =driver.getTitle();
        System.out.println(titulo);
   Assert.assertEquals(titulo,"Booking.com | Web oficial | Los mejores hoteles y alojamientos");
    }

    @Test
    public void mostarLinksTest(){
     BookingPage.obtenerEnlace();
    }

}
