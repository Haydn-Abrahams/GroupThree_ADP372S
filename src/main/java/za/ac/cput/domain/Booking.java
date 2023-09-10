package za.ac.cput.domain;


import java.sql.Time;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Booking implements Serializable{
    @Id
    private String bookingId;
    private String customerId;
    private Date date;
    private Time time;

    public Booking(){}

    public Booking(String bookingId, String customerId, Date date, Time time){
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.date = date;
        this.time = time;
    }

    private Booking(Builder builder){
        this.bookingId = builder.bookingId;
        this.customerId = builder.customerId;
        this.date = builder.date;
        this.time = builder.time;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) && Objects.equals(customerId, booking.customerId) && Objects.equals(date, booking.date) && Objects.equals(time, booking.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customerId, date, time);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", customerId=" + customerId +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    public static class Builder{
        private String bookingId;
        private String customerId;
        private Date date;
        private Time time;

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setTime(Time time) {
            this.time = time;
            return this;
        }

        public Builder copy(Booking booking){
            this.bookingId = booking.bookingId;
            this.customerId = booking.customerId;
            this.date = booking.date;
            this.time = booking.time;
            return this;
        }

        public Booking build(){return new Booking(this);}
    }
}

