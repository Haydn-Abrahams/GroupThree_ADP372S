package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.Date;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class BookingControllerTest {

    Date date = new Date();
    Time time = new Time(date.getTime());
    Booking booking = BookingFactory.buildBooking(date, time, "12345");


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/booking";

    @Test
    void a_create(){
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        ResponseEntity<Booking> postResponse = restTemplate.postForEntity(url, booking, Booking.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Booking savedBooking = postResponse.getBody();
        assertEquals(savedBooking.getBookingId(), savedBooking.getBookingId());
        System.out.println("Saved Data: " + savedBooking);
    }

    @Test
    void b_read(){
        String url = baseURL + "/read/" + booking.getBookingId();
        System.out.println("URL: " + url);
        //Get
        ResponseEntity<Booking> response = restTemplate.getForEntity(url, Booking.class);
        assertEquals(booking.getBookingId(), response.getBody().getBookingId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update(){
        Booking updated = new Booking.Builder()
                .copy(booking)
                .setCustomerId("12346")
                .setDate(date)
                .setTime(time)
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        //Post
        ResponseEntity<Booking> response = restTemplate.postForEntity(url, updated, Booking.class);

    }

    @Test
    void d_delete(){
        String bookingId = "someId";
        restTemplate.delete(baseURL + "/delete/" + bookingId);
        Booking booking = restTemplate.getForObject(baseURL + "/read/" + bookingId, Booking.class);
        assertNull(booking);
    }

    @Test
    void e_getAll(){
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
