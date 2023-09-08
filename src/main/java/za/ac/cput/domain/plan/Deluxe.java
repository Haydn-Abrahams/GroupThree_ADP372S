/** Deluxe.java
 *  This class sets the Deluxe Plan functionality
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.domain.plan;

public class Deluxe extends Plan {
    protected Deluxe() {
    }

    private Deluxe(Builder builder) {
        this.interior = builder.interior;
        this.exterior = builder.exterior;
        this.duration = builder.duration;
        this.price = builder.price;
        this.additionalServices = builder.additionalServices;
    }

    @Override
    void setAttributes() {
        interior = "WASH, WAX, POLISH, CLAY BAR TREATMENT";
        exterior = "VACCUM, WIPE-DOWN, UPHOLSTERY CLEANING, CARPET SHAMPOOING";
        duration = "3-4 hours";
        price = 2500.0;
        additionalServices = "LEATHER RESTORATION, ENGINE BAY CLEANING";
    }

    @Override
    public String displayPlan() {
        return "Deluxe{" +
                "interior='" + interior + '\'' +
                ", exterior='" + exterior + '\'' +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                ", additionalServices='" + additionalServices + '\'' +
                '}';
    }

    public static class Builder {
        protected String interior;
        protected String exterior;
        protected String duration;
        protected double price;
        protected String additionalServices;

        public Builder setInterior(String interior) {
            this.interior = interior;
            return this;
        }

        public Builder setExterior(String exterior) {
            this.exterior = exterior;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setAdditionalServices(String additionalServices) {
            this.additionalServices = additionalServices;
            return this;
        }

        public Builder copy(Deluxe deluxe) {
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
