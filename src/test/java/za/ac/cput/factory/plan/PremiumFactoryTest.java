/** PremiumFactoryTest.java
 *  This is a test class
 *  Andrea Jacobs 218024266
 *  09 September 2023 */

package za.ac.cput.factory.plan;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.plan.Deluxe;

import static org.junit.jupiter.api.Assertions.*;

class PremiumFactoryTest {
    @Test
    void premuimTest(){
        Deluxe deluxe = DeluxeFactory.createDeluxe("WASH, WAX, POLISH, CLAY BAR TREAMTMENT", "VACCUM, WIPE-DOWN, UPHOLSTERY CLEANING, CARPET SHAMPOOING", "3-4 HOURS", 2500, "LEATHER CONDITIONING, TIRE SHINE, HEADLINE RESTORATION, ENGINE BAY CLEANING");
        assertNotNull(deluxe);
        System.out.println(deluxe.displayPlan());
    }

}