/** BasicFactory.java
 *  This class builds the object
 *  Andrea Jacobs 218024266
 *  08 September 2023 */

package za.ac.cput.factory.plan;

import za.ac.cput.domain.plan.Basic;

public class BasicFactory {
    public static Basic createBasic(String interior, String exterior, String duration, double price, String additionalService){
        return new Basic.Builder()
                .setInterior(interior)
                .setExterior(exterior)
                .setDuration(duration)
                .setPrice(price)
                .setAdditionalServices(additionalService)
                .build();
    }
}
