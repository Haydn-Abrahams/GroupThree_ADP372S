/** Premium.java
 *  This class sets the Premium functionality
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.domain.plan;

public class Premium extends Plan{
    protected Premium(){}

    private Premium(Builder builder){
        this.interior = builder.interior;
        this.exterior = builder.exterior;
        this.duration = builder.duration;
        this.price = builder.price;
        this.additionalServices = builder.additionalServices;
    }


    @Override
    void setAttributes() {
        interior = "WASH, WAX, POLISH";
        exterior = "VACCUM, WIPE-DOWN, UPHOLSTERY CLEANING";
        duration = "2-3 hours";
        price = 1500.00;
        additionalServices = "LEATHER CONDITIONING, TIRE SHIRE";
    }


    @Override
    public String displayPlan() {
        return "Premium{" +
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

        public Builder copy(Premium premium){
            this.interior = premium.interior;
            this.exterior = premium.exterior;
            this.duration = premium.duration;
            this.price = premium.price;
            this.additionalServices = premium.additionalServices;
            return this;
        }

        public Premium build(){
            return new Premium(this);
        }
    }
}
