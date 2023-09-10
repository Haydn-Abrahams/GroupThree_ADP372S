package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@Builder(toBuilder = true) // Add toBuilder = true to enable copying
@AllArgsConstructor
@NoArgsConstructor
public class BaseAddress implements Serializable {
    @Id
    private Long id;
    @NotEmpty
    private String city;
    private String suburb;
    @NotEmpty
    private String state;
    @NotEmpty
    private String postalCode;
    @NotEmpty
    private String country;
}