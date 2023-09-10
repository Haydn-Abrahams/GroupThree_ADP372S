/** DeluxeFactory.java
 *  This is a test class
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.factory.plan;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.plan.Basic;
import za.ac.cput.domain.plan.Deluxe;

import static org.junit.jupiter.api.Assertions.*;

class DeluxeFactoryTest {
    @Test
    void deluxeTest(){
        Deluxe deluxe = DeluxeFactory.createDeluxe("WASH, WAX, POLISH", "VACCUM, WIPE-DOWN, UPHOLSTERY CLEANING", "2-3 HOURS", 1500, "LEATHER CONDITIONING, TIRE SHINE");
        assertNotNull(deluxe);
        System.out.println(deluxe.displayPlan());

    }

}