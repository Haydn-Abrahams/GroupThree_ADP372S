/** Deluxe.java
 *  This class sets the Deluxe Plan functionality
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.domain.plan;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;

import java.io.Serializable;

@Entity
@IdClass(Plan.class)
public class Deluxe extends Plan implements Serializable {
    public Deluxe(){}
    protected Deluxe(String planId) {
        super(planId);
    }

    private Deluxe(Builder builder) {
        this.planId = builder.planId;
        this.interior = builder.interior;
        this.exterior = builder.exterior;
        this.duration = builder.duration;
        this.price = builder.price;
        this.additionalServices = builder.additionalServices;
    }

    @Override
    public String displayPlan() {
        return "Deluxe{" +
                "plaId='" + planId + '\'' +
                "interior='" + interior + '\'' +
                ", exterior='" + exterior + '\'' +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                ", additionalServices='" + additionalServices + '\'' +
                '}';
    }

    public static class Builder {
        protected String planId;
        protected String interior;
        protected String exterior;
        protected String duration;
        protected double price;
        protected String additionalServices;

        public Builder setPlanId(String planId) {
            this.planId = planId;
            return this;
        }

        public Builder setInterior(String interior) {
            this.interior = "WASH, WAX, POLISH, CLAY BAR TREATMENT";
            return this;
        }

        public Builder setExterior(String exterior) {
            this.exterior = "VACCUM, WIPE-DOWN, UPHOLSTERY CLEANING, CARPET SHAMPOOING";;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = "3-4 hours";
            return this;
        }

        public Builder setPrice(double price) {
            this.price = 2500.00;
            return this;
        }

        public Builder setAdditionalServices(String additionalServices) {
            this.additionalServices = "LEATHER RESTORATION, ENGINE BAY CLEANING";
            return this;
        }

        public Builder copy(Deluxe deluxe) {
            this.planId = deluxe.planId;
            this.interior = deluxe.interior;
            this.exterior = deluxe.exterior;
            this.duration = deluxe.duration;
            this.price = deluxe.price;
            this.additionalServices = deluxe.additionalServices;
            return this;
        }

        public Deluxe build() {
            return new Deluxe(this);
        }
    }
}
