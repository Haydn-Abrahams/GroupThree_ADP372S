/** Basic.java
 *  This class sets the basic plan of the class
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.domain.plan;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;

import java.io.Serializable;

@Entity
@IdClass(Plan.class)
public class Basic extends Plan implements Serializable {
    public Basic(){}
    protected Basic(String planId){
        super(planId);
    }

    private Basic(Builder builder){
        this.planId = builder.planId;
        this.interior = builder.interior;
        this.exterior = builder.exterior;
        this.duration = builder.duration;
        this.price = builder.price;
        this.additionalServices = builder.additionalServices;
    }

    @Override
    public String displayPlan() {
        return "Basic{" +
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
            this.interior = "WASH, WAX";
            return this;
        }

        public Builder setExterior(String exterior) {
            this.exterior = "VACCUM, WIPE-DOWN";
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = "1-2 hours";
            return this;
        }

        public Builder setPrice(double price) {
            this.price = 500.00;
            return this;
        }

        public Builder setAdditionalServices(String additionalServices) {
            this.additionalServices = "NONE";
            return this;
        }

        public Builder copy(Basic basic){
            this.planId = basic.planId;
            this.interior = basic.interior;
            this.exterior = basic.exterior;
            this.duration = basic.duration;
            this.price = basic.price;
            this.additionalServices = basic.additionalServices;
            return this;
        }

        public Basic build(){
            return new Basic(this);
        }
    }
}
