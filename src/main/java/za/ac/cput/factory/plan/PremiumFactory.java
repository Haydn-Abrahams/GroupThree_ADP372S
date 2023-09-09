/** PremiumFactory.java
 *  This class builds the object
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.factory.plan;

import za.ac.cput.domain.plan.Premium;

public class PremiumFactory {
    public static Premium createPremium(String interior, String exterior, String duration, double price, String additionalServices){
        return new Premium.Builder()
                .setInterior(interior)
                .setExterior(exterior)
                .setDuration(duration)
                .setPrice(price)
                .setAdditionalServices(additionalServices)
                .build();
    }
}
