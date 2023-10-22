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
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Residential implements Serializable {
    @Id
    private Long id;
    @NotEmpty
    private String street_Address;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private BaseAddress baseAddress;


}

//    @OneToOne
//    @JoinColumn(name = "id")
//    private User user;