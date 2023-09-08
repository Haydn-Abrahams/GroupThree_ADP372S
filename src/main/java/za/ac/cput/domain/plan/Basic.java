/** Basic.java
 *  This class sets the basic plan of the class
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.domain.plan;

public class Basic extends Plan{
    protected Basic(){}

    private Basic(Builder builder){
        this.interior = builder.interior;
        this.exterior = builder.exterior;
        this.duration = builder.duration;
        this.price = builder.price;
        this.additionalServices = builder.additionalServices;
    }

    @Override
    void setAttributes() {
        interior = "WASH, WAX";
        exterior = "VACCUM, WIPE-DOWN";
        duration = "1-2 hours";
        price = 500.0;
        additionalServices = "None";
    }

    @Override
    public String displayPlan() {
        return "Basic{" +
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

        public Builder copy(Basic basic){
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
