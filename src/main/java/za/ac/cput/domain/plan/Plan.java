/** Plan.java
 *  This is an abstract class that sets the basic plan
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.domain.plan;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public abstract class Plan implements Serializable {
    @Id
    protected String planId;
    protected String interior;
    protected String exterior;
    protected String duration;
    protected double price;
    protected String additionalServices;

    abstract void setAttributes();
    abstract String displayPlan();

    public String getPlanId() {
        return planId;
    }

    public String getInterior() {
        return interior;
    }

    public String getExterior() {
        return exterior;
    }

    public String getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }
}
