package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.repository.IBookingRepository;
import za.ac.cput.service.BookingService;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private IBookingRepository repository;

    @Autowired
    public BookingServiceImpl(IBookingRepository repository){
        this.repository = repository;
    }


    @Override
    public Booking create(Booking booking) {
        return this.repository.save(booking);
    }

    @Override
    public Booking read(String bookingId) {
        return repository.findById(bookingId).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {
        if(repository.existsById(booking.getBookingId())){
            return repository.save(booking);
        }
        return null;
    }

    @Override
    public boolean delete(String bookingId) {
        if(this.repository.existsById(bookingId)){
            this.repository.deleteById(bookingId);
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getAll() {
        return this.repository.findAll();
    }
}
