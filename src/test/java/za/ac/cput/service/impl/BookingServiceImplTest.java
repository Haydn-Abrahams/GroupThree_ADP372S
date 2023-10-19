package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.repository.IBookingRepository;
import za.ac.cput.service.BookingService;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BookingServiceImplTest {

    @Autowired
    private BookingService bookingService;

    //@Autowired
    //private IBookingRepository bookingRepository;

    private final String customerId = "12345";
    private Booking booking = BookingFactory.buildBooking(new Date(), new Time(System.currentTimeMillis()), customerId);

    @Test
    void a_create() {
        Booking created = bookingService.create(booking);
        assertNotNull(created);
        assertEquals(booking.getBookingId(), created.getBookingId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Booking read = bookingService.read(booking.getBookingId());
        assertNotNull(read);
        //assertEquals(booking.getBookingId(), read.getBookingId());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Booking updated = new Booking.Builder().copy(booking).setCustomerId("12346").build();
        updated = bookingService.update(updated);
        assertNotNull(updated);
        assertEquals("12346", updated.getCustomerId());
        System.out.println("Updated: " + updated);

        // Adding read after update to ensure data was updated correctly in the database
        Booking reRead = bookingService.read(updated.getBookingId());
        assertEquals("12346", reRead.getCustomerId());

    }

    @Test
    void e_delete() {
        boolean deleted = bookingService.delete(booking.getBookingId());
        assertTrue(deleted);
        System.out.println("Success: " + deleted);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All");
        assertNotNull(bookingService.getAll());
    }
}
