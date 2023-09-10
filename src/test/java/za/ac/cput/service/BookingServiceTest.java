package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class BookingServiceTest {
    @Autowired
    private BookingService bookingService;
    private static Booking booking;

    @BeforeAll
    public static void setUp(){
        Date date = new Date();
        Time time = new Time(date.getTime());
        booking = BookingFactory.buildBooking(date,time, "12345");
    }

    @Test
    @Order(1)
    void save(){
        booking = bookingService.create(booking);
        assertNotNull(booking);
        assertNotNull(bookingService.read(booking.getBookingId()));
    }

    @Test
    @Order(2)
    void getById(){
        Booking readBooking = bookingService.read(booking.getBookingId());
        assertNotNull(readBooking);
        assertEquals(booking.getBookingId(), readBooking.getBookingId());
    }

    @Test
    @Order(3)
    void update(){
        Booking updatedBooking = new Booking.Builder().copy(booking).setCustomerId("67890").build();
        updatedBooking = bookingService.update(updatedBooking);
        assertNotNull(updatedBooking);
        assertEquals("67890", updatedBooking.getCustomerId());
    }

    @Test
    @Order(4)
    void deleteById(){
        boolean isDeleted = bookingService.delete(booking.getBookingId());
        assertTrue(isDeleted);
        assertNull(bookingService.read(booking.getBookingId()));
    }

    @Test
    @Order(5)
    void getAll(){
        List<Booking> bookings = bookingService.getAll();
        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());
    }

}
