package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService;
import za.ac.cput.service.impl.BookingServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private BookingServiceImpl bookingService;

    @Autowired
    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/save")
    public ResponseEntity<String> saveBooking(@RequestBody Booking booking) {
        try {
            // Validate the booking data, perform any necessary business logic, and save it
            Booking savedBooking = bookingService.create(booking);

            // Return a success response
            return new ResponseEntity<>("Booking saved with ID: " + savedBooking.getPlanName(), HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle any exceptions that may occur during the booking save process
            return new ResponseEntity<>("Error saving booking: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read/{bookingId}")
    public Booking read(@PathVariable String bookingId) {
        return bookingService.read(bookingId);
    }

    @PostMapping("/update")
    public Booking update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    @DeleteMapping ("/delete/{bookingId}")
    public boolean delete(@PathVariable String bookingId){
        return bookingService.delete(bookingId);
    }

    @GetMapping("/getAll")
    public List<Booking> getAll(){ return bookingService.getAll();}
}
