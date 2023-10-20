package za.ac.cput.domain.plan;

import jakarta.persistence.Entity;

@Entity
public class Deluxe extends Plan {
    public Deluxe() {
        this.setName("Deluxe");
        this.setExterior("Wash, Wax, & Polish");
        this.setInterior("Vacuum, Wipe-Down & Upholstery Cleaning");
        this.setDuration("2-3 Hours");
        this.setPrice(1500.0);
        this.setAdditionalServices("Leather conditioning & Tire shine");
    }
}
