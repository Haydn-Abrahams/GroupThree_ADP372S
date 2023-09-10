package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    private Long id;
    private String name;
    private String unit;
    private String floor;
    @OneToOne
    private BaseAddress baseAddress;
//    @Builder.Default
//    private boolean someFlag = true;

}