package za.ac.cput.domain.plan;

import jakarta.persistence.Entity;

@Entity
public class Basic extends Plan {
    public Basic() {
        this.setName("Basic");
        this.setExterior("Wash & Wax");
        this.setInterior("Vacuum & Wipe-Down");
        this.setDuration("1-2 Hours");
        this.setPrice(500.0);
        this.setAdditionalServices("None");
    }
}