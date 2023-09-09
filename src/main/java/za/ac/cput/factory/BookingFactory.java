package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

import java.sql.Time;
import java.util.Date;

public class BookingFactory {
    public static Booking buildBooking(Date date, Time time, Customer customerId){
        if(Helper.isNullorEmpty(String.valueOf(date)) || Helper.isNullorEmpty(String.valueOf(time) || Helper.isNullorEmpty(customerId))){
            return null;
        }

        String id = Helper.generateID();


        return new Booking.Builder().setBookingId(id)
                .setCustomerId(customerId)
                .setDate(date)
                .setTime(time)
                .build();
    }
}
