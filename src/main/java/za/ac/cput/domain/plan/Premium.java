/** Premium.java
 *  This class sets the Premium functionality
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.domain.plan;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;

import java.io.Serializable;

@Entity
@IdClass(Plan.class)
public class Premium extends Plan implements Serializable {
    public Premium(){}
    protected Premium(String planId){
        super(planId);
    }

    private Premium(Builder builder){
        this.interior = builder.interior;
        this.exterior = builder.exterior;
        this.duration = builder.duration;
        this.price = builder.price;
        this.additionalServices = builder.additionalServices;
    }




    @Override
    public String displayPlan() {
        return "Premium{" +
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
            this.interior = "WASH, WAX, POLISH";
            return this;
        }

        public Builder setExterior(String exterior) {
            this.exterior = "VACCUM, WIPE-DOWN, UPHOLSTERY CLEANING";
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = "2-3 hours";
            return this;
        }

        public Builder setPrice(double price) {
            this.price = 1500.00;
            return this;
        }

        public Builder setAdditionalServices(String additionalServices) {
            this.additionalServices = "LEATHER CONDITIONING, TIRE SHIRE";
            return this;
        }

        public Builder copy(Premium premium){
            this.planId = premium.planId;
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
