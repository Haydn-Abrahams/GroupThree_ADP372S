package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public Booking create(@RequestBody Booking booking) {
        return bookingService.create(booking);
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
