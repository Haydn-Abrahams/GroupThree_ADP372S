package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

import java.sql.Time;
import java.util.Date;

public class BookingFactory {
    public Booking createBooking(String planName, String date, String time, String email){
        if(Helper.isNullorEmpty(planName) || (Helper.isNullorEmpty(date)) || (Helper.isNullorEmpty(time)) || (Helper.isValidEmail(email))){
            return null;
        }

        String bookingId = Helper.generateID();

        return Booking.builder()
                .bookingId(bookingId)
                .planName(planName)
                .date(date)
                .time(time)
                .email(email)
                .build();
    }

}