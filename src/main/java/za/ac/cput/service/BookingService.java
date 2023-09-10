package za.ac.cput.service;

import za.ac.cput.domain.Booking;

import java.util.List;

public interface BookingService extends IService<Booking, String>{
    Booking create(Booking booking);

    Booking read(String id);

    Booking update(Booking booking);

    boolean delete(String id);

    List<Booking> getAll();
}
