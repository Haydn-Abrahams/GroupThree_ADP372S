package za.ac.cput.factory.plan;

import za.ac.cput.domain.plan.Basic;
import za.ac.cput.domain.plan.Deluxe;
import za.ac.cput.domain.plan.Plan;
import za.ac.cput.domain.plan.Premium;

public class PlanFactory {
    public static Plan createPlan(String planType) {
        if ("Basic".equalsIgnoreCase(planType)) {
            return new Basic();
        } else if ("Premium".equalsIgnoreCase(planType)) {
            return new Premium();
        } else if ("Deluxe".equalsIgnoreCase(planType)) {
            return new Deluxe();
        }
        return null; // Return null for unsupported plan types.
    }
}

