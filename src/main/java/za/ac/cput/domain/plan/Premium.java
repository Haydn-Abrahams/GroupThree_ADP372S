package za.ac.cput.domain.plan;

import jakarta.persistence.Entity;

@Entity
public class Premium extends Plan {
    public Premium() {
        this.setName("Premium");
        this.setExterior("Wash, Wax, Polish & Clay Bar Treatment");
        this.setInterior("Vacuum, Wipe-Down, Upholstery Cleaning & Carpet Cleaning");
        this.setDuration("3-4 Hours");
        this.setPrice(2500.0);
        this.setAdditionalServices("Leather conditioning, Tire shine, Headlight restoration and Engine Bay Cleaning");
    }
}