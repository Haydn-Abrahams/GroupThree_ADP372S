package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {
    @Test
    void createBooking(){
        Date date = new Date();
        Time time = new Time(System.currentTimeMillis());

        Booking booking = BookingFactory.buildBooking(date, time, "1250127519");
        System.out.println(booking.toString());
        assertNotNull(booking);
        assertNotNull(booking.getBookingId());
        assertNotNull(booking.getCustomerId());
        assertEquals(date, booking.getDate());
        assertEquals(time, booking.getTime());
    }
}
