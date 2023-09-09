/** DeluxeFactory.java
 *  This class builds the object
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.factory.plan;

import za.ac.cput.domain.plan.Deluxe;

public class DeluxeFactory {
    public static Deluxe createDeluxe (String interior, String exterior, String duration, double price, String additionalService){
        return new Deluxe.Builder()
                .setInterior(interior)
                .setExterior(exterior)
                .setDuration(duration)
                .setPrice(price)
                .setAdditionalServices(additionalService)
                .build();
    }
}
