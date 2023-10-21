package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Booking implements Serializable {
    @Id
    private String bookingId;
    private String planName;
    private String email;
    private String date;
    private String time;

}