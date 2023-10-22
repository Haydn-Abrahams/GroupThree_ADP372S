package za.ac.cput.domain;

import jakarta.persistence.*;
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
public class Complex implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complex_seq_generator")
    @SequenceGenerator(name = "complex_seq_generator", sequenceName = "complex_sequence", initialValue = 10000, allocationSize = 1)
    private Long id;
    private String name;
    private String unit;
    private String floor;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true) //Trigger deletion of the associated entity
    @JoinColumn(name = "base_address_id", referencedColumnName = "id")
    private BaseAddress baseAddress;

}