/** PlanFactory.java
 *  This class creates the objects for the various plans
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.factory.plan;

import za.ac.cput.domain.plan.Basic;
import za.ac.cput.domain.plan.Deluxe;
import za.ac.cput.domain.plan.Plan;
import za.ac.cput.domain.plan.Premium;
import za.ac.cput.util.Helper;

public class PlanFactory {
    private static String interior;
    private static String exterior;
    private static String duration;
    private static double price;
    private static String additionalService;

    public static Plan createBasic(){
        String planId = Helper.generateID();

        return new Basic.Builder()
                .setPlanId(planId)
                .setInterior(interior)
                .setExterior(exterior)
                .setDuration(duration)
                .setPrice(price)
                .setAdditionalServices(additionalService)
                .build();
    }

    public static Plan createDeluxe (){
        String planId = Helper.generateID();

        return new Deluxe.Builder()
                .setPlanId(planId)
                .setInterior(interior)
                .setExterior(exterior)
                .setDuration(duration)
                .setPrice(price)
                .setAdditionalServices(additionalService)
                .build();
    }

    public static Plan createPremium(){
        String planId = Helper.generateID();

        return new Premium.Builder()
                .setPlanId(planId)
                .setInterior(interior)
                .setExterior(exterior)
                .setDuration(duration)
                .setPrice(price)
                .setAdditionalServices(additionalService)
                .build();
    }
}
